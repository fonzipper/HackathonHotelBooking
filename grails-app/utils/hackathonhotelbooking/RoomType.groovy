package hackathonhotelbooking
public class RoomType {
    private String roomCode;
    private int roomPrice;
    private Hotel roomHotelCode;
    private String boardCode;
    private Integer adults;
    private Integer children;
    private int allotment;
    private int minFullAvailable;
    private int availability;

    String getRoomCode() {
        return roomCode
    }

    void setRoomCode(String roomCode) {
        this.roomCode = roomCode
    }

    int getRoomPrice() {
        return roomPrice
    }

    void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice
    }

    Hotel getRoomHotelCode() {
        return roomHotelCode
    }

    void setRoomHotelCode(Hotel roomHotelCode) {
        this.roomHotelCode = roomHotelCode
    }

    String getBoardCode() {
        return boardCode
    }

    void setBoardCode(String boardCode) {
        this.boardCode = boardCode
    }

    Integer getAdults() {
        return adults
    }

    void setAdults(Integer adults) {
        this.adults = adults
    }

    Integer getChildren() {
        return children
    }

    void setChildren(Integer children) {
        this.children = children
    }

    int getAllotment() {
        return allotment
    }

    void setAllotment(int allotment) {
        this.allotment = allotment
    }

    int getMinFullAvailable() {
        return minFullAvailable
    }

    void setMinFullAvailable(int minFullAvailable) {
        this.minFullAvailable = minFullAvailable
    }

    int getAvailability() {
        return availability
    }

    void setAvailability(int availability) {
        this.availability = availability
    }
}
