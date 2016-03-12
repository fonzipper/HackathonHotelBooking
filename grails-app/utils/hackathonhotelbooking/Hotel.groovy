package hackathonhotelbooking
/**
 * Created by Punker on 12.03.2016.
 */
public class Hotel {
    private def hotelCode;
    private def hotelName;
    private int hotelCategory;
    //private int distance;
    private Integer minRate;
    private Integer maxRate;

    def getHotelCode() {
        return hotelCode
    }

    void setHotelCode(hotelCode) {
        this.hotelCode = hotelCode
    }

    def getHotelName() {
        return hotelName
    }

    void setHotelName(hotelName) {
        this.hotelName = hotelName
    }

    int getHotelCategory() {
        return hotelCategory
    }

    void setHotelCategory(int hotelCategory) {
        this.hotelCategory = hotelCategory
    }

    Integer getMinRate() {
        return minRate
    }

    void setMinRate(Integer minRate) {
        this.minRate = minRate
    }

    Integer getMaxRate() {
        return maxRate
    }

    void setMaxRate(Integer maxRate) {
        this.maxRate = maxRate
    }
}
