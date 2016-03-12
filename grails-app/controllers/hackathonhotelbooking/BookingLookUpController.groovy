package hackathonhotelbooking

class BookingLookUpController {

    BookingLookUp blu;

    def index() {

        blu = new BookingLookUp();

        blu.vipSuitNumber = 10;
        blu.commonSuitNumber = 15;
        blu.familySuitNumber = 5;
        blu.radius = 5;
        blu.membersCount = 60;
        for (int i=0; i<5; i++){
            blu.AddGroupSettings();
        }

        render view: '/bookingLookUp/index',model: [booking : blu];
    }

}
