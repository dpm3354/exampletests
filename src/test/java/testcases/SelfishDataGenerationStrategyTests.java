package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.AddInvoicePage;
import pageobjects.InvoicesPage;

public class SelfishDataGenerationStrategyTests extends InvoiceTests{

	@Before
	public void setUp() {
		super.setUp();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        // Note: no clean up here.
 	}

	@After
	public void tearDown() {
        // Note: no clean up here either.

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	@Test
	public void addInvoiceTest() {
		AddInvoicePage addInvoicePage = new AddInvoicePage();

		int originalRowCount = new InvoicesPage().getInvoiceCount(driver);		

		addInvoicePage.createInvoice(driver, InvoiceDataGenerator.generate());	
		
		int rowCount = new InvoicesPage().getInvoiceCount(driver);		

		// now we have a dynamic verification point, make sure we've added one.
		assertEquals(originalRowCount+1, rowCount);
	}

}
