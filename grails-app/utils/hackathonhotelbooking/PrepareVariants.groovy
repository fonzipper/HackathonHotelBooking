package hackathonhotelbooking

/**
 * Created by Punker on 13.03.2016.
 */
class PrepareVariants {
    public static GroupOptions [] prepareVariants(Group [] groups){
        GroupOptions [] gros = new GroupOptions[3];
        GroupOptions gro1 = new GroupOptions();
        gro1.groups4Option = new ArrayList<>(groups.size());

        for (int i = 0; i < groups.length; i++) {
            Integer groups_number = 0
            for (RoomType rt : groups[i].roomTypes) {
                for(int g = 0; g < rt.minFullAvailable;g++) {
                    if (groups[i].bookingGroupSettings.accommodationType == "Single") {
                        groups_number = groups_number + Integer.valueOf(rt.adults);
                    } else {
                        groups_number = groups_number + 1;
                    }
                }
                rt.availability = 100;
                rt.occupied.add(0)
                gro1.groups4Option.putAt(i, new Group());
                gro1.groups4Option[i].roomTypes = new ArrayList<>();
                gro1.groups4Option[i].roomTypes.add(rt);
                if (groups_number >= groups[i].bookingGroupSettings.groupSize) {
                    break;
                }
            }
        }
        GroupOptions gro2 = new GroupOptions();
        gro2.groups4Option = new ArrayList<>(groups.size());

        for (int i = 0; i < groups.length; i++) {
            Integer groups_number = 0

            List<RoomType> rtByAvailability = groups[i].roomTypes.sort{it.availability};

            for (RoomType rt : rtByAvailability) {
                for(int g = 0; g < rt.minFullAvailable+1;g++) {
                    if (groups[i].bookingGroupSettings.accommodationType == "Single") {
                        groups_number = groups_number + Integer.valueOf(rt.adults);
                    } else {
                        groups_number = groups_number + 1;
                    }
                }
                rt.availability = 100 - (100/(rt.maxFullAvailable - rt.minFullAvailable));
                rt.occupied.add(1);
                gro2.groups4Option.putAt(i, new Group());
                gro2.groups4Option[i].roomTypes = new ArrayList<>();
                gro2.groups4Option[i].roomTypes.add(rt);
                if (groups_number >= groups[i].bookingGroupSettings.groupSize) {
                    break;
                }
            }
        }

        GroupOptions gro3 = new GroupOptions();
        gro3.groups4Option = new ArrayList<>(groups.size());

        for (int i = 0; i < groups.length; i++) {
            Integer groups_number = 0

            List<RoomType> rtByAvailability = groups[i].roomTypes.sort{it.availability};

            for (RoomType rt : rtByAvailability) {
                for(int g = 0; g < rt.minFullAvailable+2;g++) {
                    if (groups[i].bookingGroupSettings.accommodationType == "Single") {
                        groups_number = groups_number + Integer.valueOf(rt.adults);
                    } else {
                        groups_number = groups_number + 1;
                    }
                }
                rt.availability = 100 - (2*(100/(rt.maxFullAvailable - rt.minFullAvailable)));
                rt.occupied.add(2);
                gro3.groups4Option.putAt(i, new Group());
                gro3.groups4Option[i].roomTypes = new ArrayList<>();
                gro3.groups4Option[i].roomTypes.add(rt);
                if (groups_number >= groups[i].bookingGroupSettings.groupSize) {
                    break;
                }
            }
        }

        gros[0] = gro1;
        gros[1] = gro2;
        gros[2] = gro3;

        return gros;

    }
}
