package hackathonhotelbooking

class BookingLookUp {
    private Integer commonSuitNumber;
    private Integer familySuitNumber;
    private Integer vipSuitNumber;

    private double xLocation;
    private double yLocation;

    private String city;

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

    String getCity() {
        return city
    }

    void setCity(String city) {
        this.city = city
    }
}
