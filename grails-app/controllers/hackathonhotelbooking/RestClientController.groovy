package hackathonhotelbooking

import groovy.json.JsonSlurper
import org.joda.time.DateTime
import org.joda.time.Days

import java.text.SimpleDateFormat

class RestClientController {

    def index() {}

    def sendHotelsLook(String params){
        System.out.println(params);

        def jsn = new JsonSlurper().parseText(params);
        BookingLookUp blu = new BookingLookUp();
        blu.xLocation = jsn.lattitude?.toDouble();
        blu.yLocation = jsn.longitude?.toDouble();
        blu.fulltimeCheckIn = DateTime.parse(jsn.checkin);
        blu.fulltimeCheckOut = DateTime.parse(jsn.checkout);
        blu.radius = jsn.radius?.toDouble();

        blu.groupSettings = new ArrayList<>();


        jsn.groups?.each{group ->
            System.out.println('fuck off');
            BookingGroupSettings bgs = new BookingGroupSettings();
            if (group.size) {
                bgs.groupSize = group.size?.toInteger();
                bgs.accommodationType = group.type;
                bgs.accommodationSize = group.accSize?.toInteger();
                bgs.stars = group.stars?.toInteger();
                bgs.maxPrice = 500;
                bgs.paymentType = 'AT_WEB';
                bgs.boardType = 'BB';

                blu.groupSettings.add(bgs);
            }
        }

        List<BookingLookUp> blus = new ArrayList<>();
        BookingLookUp bluItem;

        int days = Days.daysBetween(blu.fulltimeCheckIn, blu.fulltimeCheckOut).getDays();
        if (days > 30) {
            int months = days / 30;
            if ((days % 30) > 0) months++;
            for (int i = 0; i < months; i++) {
                bluItem = (BookingLookUp) blu.clone();
                if (i != 0)
                    bluItem.fulltimeCheckIn.plusDays(30 * i + 1);
                bluItem.fulltimeCheckOut = bluItem.fulltimeCheckIn.plusDays(30 * (i+1));

                blus.add(bluItem);
            }
        }


        for(int j = 0; j<searchSettings.groupSettings.size(); j++) {
            results.add(HotelBedsHttpClient.sendRequest(req[j]));
        }
        System.out.println(results[0]);
//        String response = HotelBedsHttpClient.sendRequest(req);
        render view: '/bookingLookUp/index', model: [booking : blu]
    }
}
