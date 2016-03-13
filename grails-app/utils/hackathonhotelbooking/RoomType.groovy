package hackathonhotelbooking
public class RoomType {
    private String roomCode;
    private double roomPrice;
    private String roomHotelCode;
    private String boardCode;
    private Integer adults;
    private Integer children;
    private int allotment;
    private int minFullAvailable;
    private double availability;
    private double rating;
    public int hotelStars;

    String getRoomCode() {
        return roomCode
    }

    void setRoomCode(String roomCode) {
        this.roomCode = roomCode
    }

    double getRoomPrice() {
        return roomPrice
    }

    void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice
    }

    String getRoomHotelCode() {
        return roomHotelCode
    }

    void setRoomHotelCode(String roomHotelCode) {
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

    double getAvailability() {
        return availability
    }

    void setAvailability(double availability) {
        this.availability = availability
    }

    double getRating() {
        return rating
    }

    void setRating(double rating) {
        this.rating = rating
    }

    int getHotelStars() {
        return hotelStars
    }

    void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars
    }
}
