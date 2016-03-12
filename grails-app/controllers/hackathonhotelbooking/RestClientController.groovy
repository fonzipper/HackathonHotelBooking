

package hackathonhotelbooking

class RestClientController {

    def index() {}

    def sendHotelsLook(BookingLookUp blu){
        String req;

        String response = HotelBedsHttpClient.sendRequest(req);
    }
}
