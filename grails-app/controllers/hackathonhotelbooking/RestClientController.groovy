package hackathonhotelbooking

import groovy.json.JsonSlurper
import org.joda.time.DateTime

import java.text.SimpleDateFormat

class RestClientController {

    def index() {}

    def sendHotelsLook(String params){
        System.out.println(params);

        def jsn = new JsonSlurper().parseText(params);
        BookingLookUp blu = new BookingLookUp();
        blu.xLocation = jsn.lattitude.toDouble();
        blu.yLocation = jsn.longitude?.toDouble();
        blu.fulltimeCheckIn = DateTime.parse(jsn.checkin);
        blu.fulltimeCheckOut = DateTime.parse(jsn.checkout);
        blu.radius = jsn.radius?.toDouble();

        blu.groupSettings = new ArrayList<>(1);


        //jsn.groups?.'*'?.each{group ->
            BookingGroupSettings bgs = new BookingGroupSettings();
            bgs.groupSize = jsn.groups.group1.size.toInteger();
            bgs.accommodationType = jsn.groups.group1.type;
            bgs.accommodationSize = jsn.groups.group1.accSize.toInteger();
            bgs.stars = jsn.groups.group1.stars.toInteger();
            bgs.maxPrice = 500;
            bgs.paymentType = 'AT_WEB';
            bgs.boardType = 'BB';

            blu.groupSettings.add(bgs);

        //}

        String [] req = [5];
        BookingLookUp searchSettings = blu;
//        def df = new SimpleDateFormat('yyyy-MM-dd');

        for(int i = 0; i<searchSettings.groupSettings.size(); i++) {
            req[i] = """{
            "stay": {
                "checkIn": "${searchSettings.fulltimeCheckIn.toString('YYYY-MM-dd')}",
                "checkOut": "${searchSettings.fulltimeCheckOut.toString('YYYY-MM-dd')}"
            },
            "occupancies": [
                    {
                        "rooms": 1,
                        "adults": "${searchSettings.groupSettings[i].accommodationType == "Single" ? searchSettings.groupSettings[i].accommodationSize : 2}",
                        "children": "${searchSettings.groupSettings[i].accommodationType == "Family" ? searchSettings.groupSettings[i].accommodationSize : 0}",
                        "paxes": [
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""" +
                    (searchSettings.groupSettings[i].accommodationType == "Single" && searchSettings.groupSettings[i].accommodationSize == 3 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "Single" && searchSettings.groupSettings[i].accommodationSize == 4 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "Single" && searchSettings.groupSettings[i].accommodationSize == 5 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "Family" && searchSettings.groupSettings[i].accommodationSize == 1 ? (""",
                            {
                                "type": "CH",
                                "age": "10"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "Family" && searchSettings.groupSettings[i].accommodationSize == 2 ? (""",
                            {
                                "type": "CH",
                                "age": "10"
                            },
                            {
                                "type": "CH",
                                "age": "10"
                            }""") : "") + """
                    ]
                    }
            ],
            "filter": {
                "maxHotels": 1000,
                "maxRooms": 50,
                "maxRatesPerRoom": 3,
                "minCategory": ${searchSettings.groupSettings[i].stars},
                "maxCategory": 5,
                "paymentType": "${searchSettings.groupSettings[i].paymentType}",
                "maxRate": "${searchSettings.groupSettings.get(i).maxPrice}"
            },
            "geolocation": {
                "radius": ${searchSettings.radius},
                "latitude": ${searchSettings.xLocation},
                "longitude": ${searchSettings.yLocation},
                "unit": "km"
            }
        }""";
            System.out.println(req[0]);
        }

        def results = [];

        for(int j = 0; j<searchSettings.groupSettings.size(); j++) {
            results.add(HotelBedsHttpClient.sendRequest(req[j]));
        }
        System.out.println(results[0]);
//        String response = HotelBedsHttpClient.sendRequest(req);
        render view: '/bookingLookUp/index', model: [booking : blu]
    }
}
