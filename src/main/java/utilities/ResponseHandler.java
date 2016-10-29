package utilities;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ResponseHandler {
    public static int getResponseCode(String urlString){

		int responseCode = -1;
		try{
    		URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        responseCode = huc.getResponseCode();
		}
		catch (MalformedURLException e) {
			fail("Bad URL: " + e.getMessage());
		}
		catch (IOException e) {
			fail("IOException: " + e.getMessage());
		}
		return responseCode;
}

}
