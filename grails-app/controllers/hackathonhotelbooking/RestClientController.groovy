package hackathonhotelbooking

import groovy.json.JsonSlurper

class RestClientController {

    def index() {}

    def sendHotelsLook(String params){
        System.out.println(params);

        def jsn = new JsonSlurper().parseText(params);
        BookingLookUp blu = new BookingLookUp();
        blu.xLocation = jsn.lattitude.toDouble();
        blu.yLocation = jsn.longitude?.toDouble();
        blu.fulltimeCheckIn = Date.parse('mm-dd-yyyy', jsn.checkin);
        blu.fulltimeCheckOut = Date.parse('mm-dd-yyyy', jsn.checkout);
        blu.radius = jsn.radius?.toDouble();

        blu.groupSettings = new ArrayList<>(5);


        jsn.groups?.'*'?.each{group ->
            BookingGroupSettings bgs = new BookingGroupSettings();
            bgs.groupSize = group.size;
            bgs.accommodationType = group.type;
            bgs.accommodationSize = group.accSize;
            bgs.stars = group.stars?.text();

            blu.groupSettings.add(bgs);
        }

        String [] req = [];
        BookingLookUp searchSettings = blu;

        for(int i = 0; i<searchSettings.groupSettings.size(); i++) {
            req[i] = """{
            "stay": {
                "checkIn": "${searchSettings.fulltimeCheckIn}",
                "checkOut": "${searchSettings.fulltimeCheckOut}"
            },
            "occupancies": [
                    {
                        "rooms": 1,
                        "adults": "${
                searchSettings.groupSettings[i].accommodationType == "a" ? groupSettings.accommodationSize : 2
            }",
                        "children": "${
                searchSettings.groupSettings[i].accommodationType == "f" ? groupSettings.accommodationSize : 0
            }",
                        "paxes": [
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""" +
                    (searchSettings.groupSettings[i].accommodationType == "a" && searchSettings.groupSettings[i].accommodationSize == 3 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "a" && searchSettings.groupSettings[i].accommodationSize == 4 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "a" && searchSettings.groupSettings[i].accommodationSize == 5 ? (""",
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
                    (searchSettings.groupSettings[i].accommodationType == "f" && searchSettings.groupSettings[i].accommodationSize == 1 ? (""",
                            {
                                "type": "CH",
                                "age": "10"
                            }""") : "") +
                    (searchSettings.groupSettings[i].accommodationType == "f" && searchSettings.groupSettings[i].accommodationSize == 2 ? (""",
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
                "maxRate": "${searchSettings.groupSettings[i].maxPrice}"
            },""" + (searchSettings.groupSettings[i].boardType != null) ? ("""
            "boards": {
                "included": true,
                "board": [
                        "${searchSettings.groupSettings[i].boardType}"
                ]
            },""") : "" + """
            "geolocation": {
                "radius": ${searchSettings.radius},
                "latitude": ${searchSettings.xLocation},
                "longitude": ${searchSettings.yLocation},
                "unit": "km"
            }
        }"""
        }
        for(int j = 0; j<searchSettings.groupSettings.size(); j++) {
            HotelBedsHttpClient.sendRequest(req[j]);
        }

//        String response = HotelBedsHttpClient.sendRequest(req);
        render view: '/bookingLookUp/index'
    }
}
