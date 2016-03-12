package hackathonhotelbooking

import groovy.json.JsonSlurper

class RestClientController {

    def index() {}

    def sendHotelsLook(String params){
        System.out.println(params);
        String req;

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


//        String response = HotelBedsHttpClient.sendRequest(req);
        render view: '/bookingLookUp/index'
    }
}
