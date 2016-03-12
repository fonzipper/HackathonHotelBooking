public class Room {
    //private int id;
    private string roomCode;
    private int roomPrice;
    private Hotel roomHotelCode;
    private string boardCode;
    private int [] occupied;
    Room [] rooms;
    public void addRooms(/*string roomCode_I, int roomPrice_I, string boardCode_I, Hotel roomHotelCode_I, int allotment*/ RoomEntry [] roomEntries){
        for (int i = 0; i < roomEntries.length; i++){
            for (int j = 0; j < roomEntries[i].allotment; j++){
                rooms.add(new Room(roomCode = roomEntries[i].roomCode_I, roomPrice = roomEntries[i].roomPrice_I, roomHotelCode = roomEntries[i].roomHotelCode_I, boardCode = roomEntries[i].boardCode_I, occupied = []))
            }
        }
    }
/*int getId(){
return id
}
void setId(int id){this.id=id
}*/
    public string getRoomCode(){
return roomCode
}
void setRoomCode(string roomCode){this.roomCode=roomCode
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
    public string getBoardCode(){
return boardCode
}
void setBoardCode(string boardCode){this.boardCode=boardCode
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
}
