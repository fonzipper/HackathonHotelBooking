

package hackathonhotelbooking

class RestClientController {

    def index() {}

    def sendHotelsLook(BookingGroupSettings groupSettings, BookingLookUp searchSettings){
        String [] req = [];

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
    }
}
