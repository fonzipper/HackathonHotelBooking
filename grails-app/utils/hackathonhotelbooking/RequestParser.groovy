package hackathonhotelbooking
import groovy.json.JsonSlurper
/**
 * Created by Punker on 12.03.2016.
 */
class RequestParser {
    public static String[][] prepareRequest(List<BookingLookUp> searchSettings) {
        System.out.println(searchSettings.size());
        String[][] req = new String [searchSettings.size()][searchSettings[0]?.groupSettings?.size()];
        for (int month = 0; month < searchSettings.size(); month++) {

            for (int group = 0; group < searchSettings[month].groupSettings.size(); group++) {
//                req[month] = [searchSettings[month].groupSettings.size()];
                String per = """{
            "stay": {
                "checkIn": "${searchSettings[month].fulltimeCheckIn.toString('YYYY-MM-dd')}",
                "checkOut": "${searchSettings[month].fulltimeCheckOut.toString('YYYY-MM-dd')}"
            },
            "occupancies": [
                    {
                        "rooms": 1,
                        "adults": "${
                    searchSettings[month].groupSettings[group].accommodationType == "Single" ? searchSettings[month].groupSettings[group].accommodationSize : 2
                }",
                        "children": "${
                    searchSettings[month].groupSettings[group].accommodationType == "Family" ? searchSettings[month].groupSettings[group].accommodationSize : 0
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
                        (searchSettings[month].groupSettings[group].accommodationType == "Single" && searchSettings[month].groupSettings[group].accommodationSize == 3 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                        (searchSettings[month].groupSettings[group].accommodationType == "Single" && searchSettings[month].groupSettings[group].accommodationSize == 4 ? (""",
                            {
                                "type": "AD",
                                "age": "30"
                            },
                            {
                                "type": "AD",
                                "age": "30"
                            }""") : "") +
                        (searchSettings[month].groupSettings[group].accommodationType == "Single" && searchSettings[month].groupSettings[group].accommodationSize == 5 ? (""",
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
                        (searchSettings[month].groupSettings[group].accommodationType == "Family" && searchSettings[month].groupSettings[group].accommodationSize == 1 ? (""",
                            {
                                "type": "CH",
                                "age": "10"
                            }""") : "") +
                        (searchSettings[month].groupSettings[group].accommodationType == "Family" && searchSettings[month].groupSettings[group].accommodationSize == 2 ? (""",
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
                "minCategory": ${searchSettings[month].groupSettings[group].stars},
                "maxCategory": 5,
                "paymentType": "AT_WEB",
                "maxRate": "50000"
            },
            "geolocation": {
                "radius": ${searchSettings[month].radius},
                "latitude": ${searchSettings[month].xLocation},
                "longitude": ${searchSettings[month].yLocation},
                "unit": "km"
            }
        }""";
                req[month][group] = per;
                System.out.println(per)
            }
        }
        return req;
    }


    public static SearchResults[][] parseResponse(String[][] res) {
        SearchResults [][] searchResults = new SearchResults [res.length][res[0].length];
        for (int month = 0; month < res.length; month++) {
            for (int group = 0; group < res[month].length; group++) {
                List<RoomType> roomtypes = new ArrayList<>();
                List<Hotel> hotels = new ArrayList<>();
                JsonSlurper jsonSlurper = new JsonSlurper();
                def result = jsonSlurper.parseText(res[month][group]);
                System.out.println(res[month][group])
                int total = result.hotels.total;
                result.hotels.hotels?.each{hotel ->
                    Hotel htl = new Hotel();

                    htl.hotelCode = hotel.code;
                    htl.hotelName = hotel.name;
//                    htl.hotelCategory = hotel.categoryName;
//                    htl.minRate = hotel.minRate.toInteger();
//                    htl.maxRate = hotel.maxRate.toInteger();
                    hotels.add(htl)

                    hotel.rooms?.each{room ->
                        room.rates?.each { rate ->
                            RoomType rm = new RoomType();
                            rm.roomName = room.name;
                            rm.roomCode=room.code;
                            rm.roomPrice=rate.net.toDouble();
                            rm.roomHotelCode=hotel.code;
                            rm.hotelName = hotel.name;
                            rm.boardCode=rate.boardCode;
                            rm.boardName = rate.boardName;
                            rm.adults= rate.adults;
                            rm.children= rate.children;
                            rm.allotment=rate.allotment;
                            String ct = hotel.categoryName;
                            if (ct == 'HOSTEL')
                                rm.hotelStars=1;
                            else{
                                def st = ct.substring(0,1);
                                rm.hotelStars = st.toInteger();
                            }
                            roomtypes.add(rm);
                            System.out.println('+++');
                        }
                    }
                }
                SearchResults sr = new SearchResults()
                sr.hotels = hotels;
                sr.roomTypes = roomtypes;
                searchResults[month][group] = sr;
            }
        }
        return searchResults;
    }
}
