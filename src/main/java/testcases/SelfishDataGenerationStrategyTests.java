package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.DataCleaner;
import pageobjects.AddInvoicePage;
import pageobjects.InvoicesPage;
import utilities.TimingManager;

public class SelfishDataGenerationStrategyTests extends InvoiceTests{

	@Before
	public void setUp() {
		super.setUp();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        // Note there is no clean up here.
 	}

	@After
	public void tearDown() {
        // Note there is no clean up here either.

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	@Test
	public void addInvoiceTest() {
		AddInvoicePage addInvoicePage = new AddInvoicePage();

		int originalRowCount = new InvoicesPage().getInvoiceCount(driver);		

		addInvoicePage.clickAddInvoice(driver);		
		addInvoicePage.createInvoice(driver, InvoiceDataGenerator.generate());	

		TimingManager.wait(500);
		
		int rowCount = new InvoicesPage().getInvoiceCount(driver);		

		// now we have a dynamic verification point, make sure we've added one.
		assertEquals(originalRowCount+1, rowCount);
	}

}
