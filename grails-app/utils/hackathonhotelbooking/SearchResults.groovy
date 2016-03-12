package hackathonhotelbooking
/**
 * Created by Punker on 12.03.2016.
 */

public class SearchResults {
    private List<Room> rooms;
    private List<Hotel> hotels;

    List<Room> getRooms() {
        return rooms
    }

    void setRooms(List<Room> rooms) {
        this.rooms = rooms
    }

    List<Hotel> getHotels() {
        return hotels
    }

    void setHotels(List<Hotel> hotels) {
        this.hotels = hotels
    }
}