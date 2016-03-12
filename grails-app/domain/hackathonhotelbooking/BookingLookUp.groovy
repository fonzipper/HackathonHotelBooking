package hackathonhotelbooking

import org.joda.time.DateTime

class BookingLookUp {
    private Integer commonSuitNumber;
    private Integer familySuitNumber;
    private Integer vipSuitNumber;
    private Integer membersCount;
    private String accommodationQuantity;

    private DateTime fulltimeCheckIn;
    private DateTime fulltimeCheckOut;

    private Date[] parttimeCheckIn;
    private Date[] parttimeCheckOut;

    private List<BookingGroupSettings> groupSettings;


    private double xLocation;
    private double yLocation;

    private double radius;

    private String city;
    private String location;

//    public BookingLookUp() {
//
//    }

    public List<BookingGroupSettings> AddGroupSettings(){
        if (this.groupSettings == null) {
            this.groupSettings = new ArrayList<>();
        }

        BookingGroupSettings bgs = new BookingGroupSettings();
        bgs.innerId = this.groupSettings.size() + 1;

        this.groupSettings.add(bgs);

        return this.groupSettings;
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

    DateTime getFulltimeCheckOut() {
        return fulltimeCheckOut
    }

    void setFulltimeCheckOut(DateTime checkOut) {
        this.fulltimeCheckOut = checkOut
    }

    DateTime getFulltimeCheckIn() {
        return fulltimeCheckIn
    }

    void setFulltimeCheckIn(DateTime checkIn) {
        this.fulltimeCheckIn = checkIn
    };

    Date[] getParttimeCheckOut() {
        return parttimeCheckOut
    }

    void setParttimeCheckOut(Date[] parttimeCheckOut) {
        this.parttimeCheckOut = parttimeCheckOut
    }

    Date[] getParttimeCheckIn() {
        return parttimeCheckIn
    }

    void setParttimeCheckIn(Date[] parttimeCheckIn) {
        this.parttimeCheckIn = parttimeCheckIn
    }

    List<BookingGroupSettings> getGroupSettings() {
        return groupSettings
    }

    void setGroupSettings(List<BookingGroupSettings> groupSettings) {
        this.groupSettings = groupSettings
    }
}
