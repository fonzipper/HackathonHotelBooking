package hackathonhotelbooking
/**
 * Created by Punker on 13.03.2016.
 */
class SetAvailability {
    public static Group [] setAvailability(SearchResults[][] searchResults){
        Group [] groups = new Group[searchResults[0].length];
        for(int group = 0; group < searchResults[0].length; group++){
            groups[group] = new Group();
            groups[group].roomTypes = new ArrayList<>();
            for (RoomType rt : searchResults[0][group].roomTypes){
                List <Integer> allotments = [searchResults.length]
                int price = rt.roomPrice
                allotments[0] = rt.allotment ?: 0;
                for(int month = 1; month < searchResults.length; month++){
                    for (RoomType rt_2 : searchResults[month][group].roomTypes){
                        if (rt.adults==rt_2.adults && rt.children==rt_2.children && rt.boardCode==rt_2.boardCode && rt.roomHotelCode==rt_2.roomHotelCode && rt.roomCode==rt_2.roomCode){
                            allotments[month] = rt_2.allotment ?: 0;
                            price = price + rt_2.roomPrice;
                        }

                    }
                }
                RoomType rt_res = new RoomType();
                rt_res.roomName = rt.roomName.capitalize();
                rt_res.boardName = rt.boardName.capitalize();
                rt_res.hotelName = rt.hotelName;
                rt_res.roomPrice = price;
                rt_res.roomCode = rt.roomCode;
                rt_res.roomHotelCode = rt.roomHotelCode;
                rt_res.boardCode = rt.boardCode;
                rt_res.adults = rt.adults;
                rt_res.children = rt.children;
                rt_res.maxFullAvailable = allotments.max();
                rt_res.minFullAvailable = allotments.min();
                def almax = 0;
                def alsum = 0;
                for (Integer al : allotments) {
                    if (al != null){
                        if (al > almax) almax = al;
                        alsum = alsum + al;
                    }
                }
                rt_res.availability = (alsum/allotments.size())/almax;
                rt_res.rating = Integer.valueOf(rt_res.minFullAvailable) * rt_res.hotelStars / rt_res.roomPrice;
                groups[group].roomTypes.add(rt_res);
            }
            groups[group].roomTypes = groups[group].roomTypes.sort{it.rating};
        }
        return groups;
    }
}
