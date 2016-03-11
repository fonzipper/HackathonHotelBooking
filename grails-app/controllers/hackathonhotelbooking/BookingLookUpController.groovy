package hackathonhotelbooking

class BookingLookUpController {

    def index() {

        BookingLookUp blu = new BookingLookUp();

        blu.vipSuitNumber = 10;
        blu.commonSuitNumber = 15;
        blu.familySuitNumber = 5;
        blu.radius = 5;

        render view: '/bookingLookUp/index',model: [booking : blu];
    }
}
