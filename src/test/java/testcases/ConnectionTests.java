package testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utilities.ResponseHandler;

public class ConnectionTests extends InvoiceTests{


	@Test
	public void siteIsAliveTest(){
		assertTrue("Did not get 200 response from site", ResponseHandler.getResponseCode(baseUrl) == 200);
	}

}
