package hackathonhotelbooking

class BookingLookUp {
    private Integer commonSuitNumber;
    private Integer familySuitNumber;
    private Integer vipSuitNumber;
    private Integer membersCount;
    private String accommodationQuantity;

    private Date fulltimeCheckIn;
    private Date fulltimeCheckOut;


    private double xLocation;
    private double yLocation;

    private double radius;

    private String city;
    private String location;

    public BookingLookUp() {

    }



    Integer getCommonSuitNumber() {
        return commonSuitNumber
    }

    void setCommonSuitNumber(Integer commonSuitNumber) {
        this.commonSuitNumber = commonSuitNumber
    }

    Integer getFamilySuitNumber() {
        return familySuitNumber
    }

    void setFamilySuitNumber(Integer familySuitNumber) {
        this.familySuitNumber = familySuitNumber
    }

    Integer getVipSuitNumber() {
        return vipSuitNumber
    }

    void setVipSuitNumber(Integer vipSuitNumber) {
        this.vipSuitNumber = vipSuitNumber
    }

    double getxLocation() {
        return xLocation
    }

    void setxLocation(double xLocation) {
        this.xLocation = xLocation
    }

    double getyLocation() {
        return yLocation
    }

    void setyLocation(double yLocation) {
        this.yLocation = yLocation
    }

    double getRadius() {
        return radius
    }

    void setRadius(double radius) {
        this.radius = radius
    }

    String getCity() {
        return city
    }

    void setCity(String query) {
        this.city = query
    }

    Integer getMembersCount() {
        return membersCount
    }

    void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount
    }

    String getLocation() {
        return location
    }

    void setLocation(String location) {
        this.location = location
    }

    String getAccommodationQuantity() {
        return accommodationQuantity
    }

    void setAccommodationQuantity(String accommodationQuantity) {
        this.accommodationQuantity = accommodationQuantity
    }

    Date getFulltimeCheckOut() {
        return fulltimeCheckOut
    }

    void setFulltimeCheckOut(Date checkOut) {
        this.fulltimeCheckOut = checkOut
    }

    Date getFulltimeCheckIn() {
        return fulltimeCheckIn
    }

    void setFulltimeCheckIn(Date checkIn) {
        this.fulltimeCheckIn = checkIn
    };
}
