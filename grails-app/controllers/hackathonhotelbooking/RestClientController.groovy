package hackathonhotelbooking

import groovy.json.JsonSlurper
import org.joda.time.DateTime
import org.joda.time.Days

class RestClientController {

    def index() {}

    def sendHotelsLook(String params){

        def jsn = new JsonSlurper().parseText(params);
        BookingLookUp blu = new BookingLookUp();
        blu.xLocation = jsn.lattitude?.toDouble();
        blu.yLocation = jsn.longitude?.toDouble();
        blu.fulltimeCheckIn = DateTime.parse(jsn.checkin);
        blu.fulltimeCheckOut = DateTime.parse(jsn.checkout);
        blu.radius = jsn.radius?.toDouble();

        blu.groupSettings = new ArrayList<>();


        jsn.groups?.each{group ->
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
        BookingGroupSettings bgsItem;

        int days = Days.daysBetween(blu.fulltimeCheckIn, blu.fulltimeCheckOut).getDays();
        if (days > 30) {
            int months = days / 30;
            if ((days % 30) > 0) months++;
            for (int i = 0; i < months; i++) {
                bluItem = new BookingLookUp([fulltimeCheckIn:blu.fulltimeCheckIn, fulltimeCheckOut:blu.fulltimeCheckOut, xLocation:blu.xLocation, yLocation:blu.yLocation, radius:blu.radius]);
                bluItem.groupSettings = new ArrayList<>();
                for (BookingGroupSettings bg : blu.groupSettings){
                    bgsItem = new BookingGroupSettings([groupSize : bg.groupSize, accommodationType : bg.accommodationType, accommodationSize : bg.accommodationSize, stars : bg.stars]);
                    bluItem.groupSettings.add(bgsItem);
                }
                //(BookingLookUp) blu.clone();
                if (i != 0) bluItem.fulltimeCheckIn = bluItem.fulltimeCheckIn.plusDays(30 * i + 1);
                bluItem.fulltimeCheckOut = bluItem.fulltimeCheckIn.plusDays(30);

                blus.add(bluItem);
            }
        }
        def requests = RequestParser.prepareRequest(blus);
        String [][] responses = new String[blus.size()][blus[0].groupSettings.size()];
        for (int month = 0; month < blus.size(); month++) {
            for (int group = 0; group < blus[0].groupSettings.size(); group++) {

                def request = requests[month][group];
                responses[month][group] = HotelBedsHttpClient.sendRequest(request);
            }
        }
        def parsedResponse = RequestParser.parseResponse(responses, blus[0].getGroupSettings());

        Group[] groups = SetAvailability.setAvailability(parsedResponse);
        GroupOptions[] gOptions = PrepareVariants.prepareVariants(groups);
        List<Group> sortedGroups = new ArrayList<>(groups.size()*gOptions.size());
        for (int i = 0; i < gOptions.length ; i++) {
            for(int j = 0; j < gOptions[i].groups4Option.size(); j++){
                sortedGroups.putAt(i+gOptions.length*j,gOptions[i].groups4Option[j])
            }
        }

        List<GroupOptions> go = new ArrayList<>(groups.size());
        int k = 0;
        int n = 0;
        while (k < sortedGroups.size()){
            go[n] = new GroupOptions();
            go[n].groups4Option = new ArrayList<>();
//            Group grp = sortedGroups.get(k);
            go[n].groups4Option.add(sortedGroups.get(k));
            k++;
            go[n].groups4Option.add(sortedGroups.get(k));
            k++;
            go[n].groups4Option.add(sortedGroups.get(k));
            k++;
            n++;
        }


        render template: '/layouts/resultList', model: [booking : blu, roomGroups : go]
    }
}
