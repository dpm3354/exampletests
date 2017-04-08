package db;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import testcases.InvoiceTests;
import utilities.Configuration;

public class DataCleaner {

	public static void deleteAllInvoices() {
		
		try {
			URL url = new URL("http://"+Configuration.apiIp+":"+Configuration.apiPort+"/deleteAllInvoices");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("DELETE");
			huc.connect();
			if(huc.getResponseCode() != 200)
				System.out.println("Did not respond with 200, got " +huc.getResponseCode() +" instead.");
			else{
				System.out.println("Responded with 200, cleaned.");
			}
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
