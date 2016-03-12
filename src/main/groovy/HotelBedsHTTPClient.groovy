import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpClient
import org.apache.http.client.ResponseHandler
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils

/**
 * Created by NS on 12/03/16.
 */
class HotelBedsHTTPClient {
    public static String sendRequest(Map<String,String> params){
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost('http://testapi.hotelbeds.com/hotel-api/1.0/hotels');
        post.addHeader('Api-Key','gfhpht2ffsfejd88g7pcnexe');
        post.addHeader('Content-Type','application/json');
        post.addHeader('Accept','application/json');

        post.setEntity(new StringEntity(params['body']));
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        String response = client.execute(post, responseHandler);
        return response;
    }

}
