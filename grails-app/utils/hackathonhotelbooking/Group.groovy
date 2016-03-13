package hackathonhotelbooking

/**
 * Created by Punker on 13.03.2016.
 */
class Group {
    private List<RoomType> roomTypes;
    private List<BookingGroupSettings> bookingGroupSettings;

    List<BookingGroupSettings> getBookingGroupSettings() {
        return bookingGroupSettings
    }

    void setBookingGroupSettings(List<BookingGroupSettings> bookingGroupSettings) {
        this.bookingGroupSettings = bookingGroupSettings
    }

    List<RoomType> getRoomTypes() {
        return roomTypes
    }

    void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes
    }
}
