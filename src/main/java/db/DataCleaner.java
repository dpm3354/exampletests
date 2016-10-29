package db;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class DataCleaner {

	public static void deleteAllInvoices() {

		try {
			URL url = new URL("http://52.86.128.173:8081/deleteAllInvoices");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("DELETE");
			huc.connect();
			if(huc.getResponseCode() != 200)
				System.out.println("Did not respond with 200, got " +huc.getResponseCode() +" instead.");
		} catch (MalformedURLException e) {
			fail("Bad URL: " + e.getMessage());
		} catch (IOException e) {
			fail("IOException: " + e.getMessage());
		}

	}

	public static void main(String argv[]){
		deleteAllInvoices();
	}

}
