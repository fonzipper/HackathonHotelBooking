package hackathonhotelbooking

class BookingGroupSettings {
    private Integer groupSize;
    private String accommodationType;
    private Integer accommodationSize;
    private Integer stars;
    private String name;
    private int innerId;

    Integer getGroupSize() {
        return groupSize
    }

    void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize
    }

    Integer getAccommodationSize() {
        return accommodationSize
    }

    void setAccommodationSize(Integer accommodationSize) {
        this.accommodationSize = accommodationSize
    }

    Integer getStars() {
        return stars
    }

    void setStars(Integer stars) {
        this.stars = stars
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    int getInnerId() {
        return innerId
    }

    void setInnerId(int innerId) {
        this.innerId = innerId
    }

    String getAccommodationType() {
        return accommodationType
    }

    void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType
    }
}
