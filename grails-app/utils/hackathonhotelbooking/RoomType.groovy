package hackathonhotelbooking
public class RoomType {
    private String roomName;
    private String roomCode;
    private int roomPrice;
    private String hotelName;
    private Hotel roomHotelCode;
    private String boardCode;
    private String boardName;
    private Integer adults;
    private Integer children;
    private int allotment;
    private int minFullAvailable;
    private int maxFullAvailable;
    private int availability;
    private double rating;
    public int hotelStars;

    String getRoomName() {
        return roomName
    }

    void setRoomName(String roomName) {
        this.roomName = roomName
    }

    String getBoardName() {
        return boardName
    }

    void setBoardName(String boardName) {
        this.boardName = boardName
    }

    int getMaxFullAvailable() {
        return maxFullAvailable
    }

    void setMaxFullAvailable(int maxFullAvailable) {
        this.maxFullAvailable = maxFullAvailable
    }

    String getHotelName() {
        return hotelName
    }

    void setHotelName(String hotelName) {
        this.hotelName = hotelName
    }

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
