/**
 * Created by Punker on 12.03.2016.
 */
public class RoomEntry {
    private def roomCode_I;
    private int roomPrice_I;
    private def boardCode_I;
    private Hotel roomHotelCode_I;
    private int allotment;
    public def getRoomCode_I() {
        return roomCode_I;
    }

    void setRoomCode_I(def roomCode_I) {
        this.roomCode_I = roomCode_I;
    }

    public int getRoomPrice_I() {
        return roomPrice_I;
    }

    void setRoomPrice_I(int roomPrice_I) {
        this.roomPrice_I = roomPrice_I;
    }

    public def getBoardCode_I() {
        return boardCode_I;
    }

    void setBoardCode_I(def boardCode_I) {
        this.boardCode_I = boardCode_I;
    }

    public Hotel getRoomHotelCode_I() {
        return roomHotelCode_I;
    }

    void setRoomHotelCode_I(Hotel roomHotelCode_I) {
        this.roomHotelCode_I = roomHotelCode_I;
    }

    public int getAllotment() {
        return allotment;
    }

    void setAllotment(int allotment) {
        this.allotment = allotment;
    }
}
