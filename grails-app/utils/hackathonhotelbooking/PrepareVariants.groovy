package hackathonhotelbooking

/**
 * Created by Punker on 13.03.2016.
 */
class PrepareVariants {
    public static Result [] prepareVariants(Group [] groups){
        Result [] rslt = new Result[5];
        Result new_rslt = new Result();
        for(int k = 0; k<rslt.length; k++) {
            for (int i = 0; i < groups.length; i++) {
                Integer groups_number = 0
                for (RoomType rt : groups[i].roomTypes) {
                    if (groups[i].bookingGroupSettings.accommodationType == "Single") {
                        rt.occupied.add(k);
                        rslt[k].groups[i].roomTypes.add(rt);
                        groups_number = groups_number + rt.adults;
                    } else {
                        rslt[k].groups[i].roomTypes.add(rt);
                        groups_number = groups_number + 1;
                    }
                    if(groups_number>=groups[i].bookingGroupSettings.groupSize){
                        break;
                    }
                }
            }
        }
        return rslt;

    }
}
