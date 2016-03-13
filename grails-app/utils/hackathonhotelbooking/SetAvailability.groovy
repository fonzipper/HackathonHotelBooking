package hackathonhotelbooking
/**
 * Created by Punker on 13.03.2016.
 */
class SetAvailability {
    public static Group [] setAvailability(SearchResults[][] searchResults){
        Group [] groups = new Group[searchResults[0].length];
        for(int group = 0; group < searchResults[0].length; group++){
            for (RoomType rt : searchResults[0][group].roomTypes){
                List <Integer> allotments = [searchResults.length]
                int price = rt.roomPrice
                allotments[0] = rt.allotment;
                for(int month = 1; month < searchResults.length; month++){
                    for (RoomType rt_2 : searchResults[month][group].roomTypes){
                        if (rt.adults==rt_2.adults && rt.children==rt_2.children && rt.boardCode==rt_2.boardCode && rt.roomHotelCode==rt_2.roomHotelCode && rt.roomCode==rt_2.roomCode){
                            allotments[month] = rt_2.allotment
                            price = price + rt_2.roomPrice;
                        }

                    }
                }
                RoomType rt_res = new RoomType();
                rt_res.roomPrice = price;
                rt_res.roomCode = rt.roomCode;
                rt_res.roomHotelCode = rt.roomHotelCode;
                rt_res.boardCode = rt.boardCode;
                rt_res.adults = rt.adults;
                rt_res.children = rt.children;
                rt_res.minFullAvailable = allotments.min();
                rt_res.availability = (allotments.sum()/allotments.size())/allotments.max();
                groups[group].roomTypes.add(rt_res)
            }
        }
        return groups;
    }
}
