package hackathonhotelbooking
import groovy.json.JsonSlurper
/**
 * Created by Punker on 12.03.2016.
 */
class RequestParser {
    public static String[] prepareRequest(List<BookingLookUp> searchSettings) {
        String[][] req;
        for (int month = 0; month < searchSettings.length; month++) {

            for (int group = 0; group < searchSettings[month].groupSettings.size(); group++) {

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
                "paymentType": "${searchSettings[month].groupSettings[group].paymentType}",
                "maxRate": "${searchSettings[month].groupSettings[group].maxPrice}"
            },""" + searchSettings[month].groupSettings[group].boardType != null ? """ "boards": {
    "included": true,
    "board": [
      "${searchSettings[month].groupSettings[group].boardType}"
    ]
  },""" : "" + """
            "geolocation": {
                "radius": ${searchSettings[month].radius},
                "latitude": ${searchSettings[month].xLocation},
                "longitude": ${searchSettings[month].yLocation},
                "unit": "km"
            }
        }""";
                req[month][group] = per;
                //System.out.println(req[0]);
            }
        }
        return req;
    }


    public static void parseResponse(String[][] res) {
        SearchResults [][] searchResults;
        for (int month = 0; month < res.length; month++) {
            for (int group = 0; group < res[month].length; group++) {
                List<Room> rooms = new ArrayList<>();
                List<Hotel> hotels = new ArrayList<>();
                JsonSlurper jsonSlurper = new JsonSlurper();
                def result = jsonSlurper.parseText(res[month][group]);
                int total = result.hotels.total;
                result.hotels.hotels?.each{hotel ->
                    Hotel htl = new Hotel();

                    htl.hotelCode = hotel.code;
                    htl.hotelName = hotel.name;
                    htl.hotelCategory = hotel.categoryName;
                    htl.minRate = hotel.minRate;
                    htl.maxRate = hotel.maxRate;
                    hotels.add(htl)

                    hotel.rooms?.each{room ->
                        room.rates?.each { rate ->
                            Room rm = new Room();
                            /*rooms.add(new Room(roomCode:room.code,
                                    roomPrice: rate.net,
                                    roomHotelCode:result.hotels.hotels[k].code,
                                    boardCode:rate.boardCode,
                                    occupied:[],
                                    adults: rate.adults,
                                    children: rate.children
                            ));*/
                            rm.roomCode=room.code;
                            rm.roomPrice= rate.net;
                            rm.roomHotelCode=hotel.code;
                            rm.boardCode=rate.boardCode;
                            rm.occupied=[];
                            rm.adults= rate.adults;
                            rm.children= rate.children;
                            rooms.add(rm);
                        }
                    }
                }
                SearchResults sr = new SearchResults()
                sr.hotels = hotels;
                sr.rooms = rooms;
                searchResults[month][group] = sr;
            }
        }
    }
}
