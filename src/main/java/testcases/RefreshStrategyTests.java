package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.DataCleaner;
import pageobjects.AddInvoicePage;
import pageobjects.InvoicesPage;
import utilities.TimingManager;

public class RefreshStrategyTests extends InvoiceTests{

	@Before
	public void setUp() {
		super.setUp();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        // This is our "refresh" code, in this case it just deletes the entire db.
        DataCleaner.deleteAllInvoices();
 	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	@Test
	public void addInvoiceTest() {
		AddInvoicePage addInvoicePage = new AddInvoicePage();
		
		addInvoicePage.clickAddInvoice(driver);		
		addInvoicePage.createInvoice(driver);	

		TimingManager.wait(500);
		
		int rowCount = new InvoicesPage().getInvoiceCount(driver);		

		assertEquals(1, rowCount-1);
	}

}
