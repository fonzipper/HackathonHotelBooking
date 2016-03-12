package hackathonhotelbooking
public class Room {
    private String roomCode;
    private int roomPrice;
    private Hotel roomHotelCode;
    private String boardCode;
    private Integer adults;
    private Integer children;
    private int [] occupied;

    public def getRoomCode(){
        return roomCode
    }
    void setRoomCode(def roomCode){this.roomCode=roomCode
    }
    public int getRoomPrice(){
        return roomPrice
    }
    void setRoomPrice(int roomPrice){this.roomPrice=roomPrice
    }
    public Hotel getRoomHotelCode(){
        return roomHotelCode
    }
    void setRoomHotelCode(Hotel roomHotelCode){this.roomHotelCode=roomHotelCode
    }
    public def getBoardCode(){
        return boardCode
    }
    void setBoardCode(def boardCode){this.boardCode=boardCode
    }
    public int[] getOccupied(){
        return occupied
    }
    void setOccupied(int[] occupied){this.occupied=occupied
    }
    public Room[] getRooms(){
        return rooms
    }
    void setRooms(Room[] rooms){this.rooms=rooms
    }

    void setBoardCode(String boardCode) {
        this.boardCode = boardCode
    }

    void setRoomCode(String roomCode) {
        this.roomCode = roomCode
    }

    Integer getChildren() {
        return children
    }

    void setChildren(Integer children) {
        this.children = children
    }

    Integer getAdults() {
        return adults
    }

    void setAdults(Integer adults) {
        this.adults = adults
    }
}
