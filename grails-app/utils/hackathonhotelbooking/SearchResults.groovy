package hackathonhotelbooking
/**
 * Created by Punker on 12.03.2016.
 */

public class SearchResults {
    private List<RoomType> roomTypes;
    private List<Hotel> hotels;
    private List<BookingGroupSettings> groups;

    List<BookingGroupSettings> getGroups() {
        return groups
    }

    void setGroups(List<BookingGroupSettings> groups) {
        this.groups = groups
    }

    List<RoomType> getRoomTypes() {
        return roomTypes
    }

    void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes
    }

    List<Hotel> getHotels() {
        return hotels
    }

    void setHotels(List<Hotel> hotels) {
        this.hotels = hotels
    }
}