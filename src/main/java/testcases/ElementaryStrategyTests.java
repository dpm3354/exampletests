package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.AddInvoicePage;
import pageobjects.InvoicesPage;
import utilities.ResponseHandler;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementaryStrategyTests {
	private WebDriver driver;
	private static final String baseUrl = "http://52.55.130.111";
	private static final String pathToChromeDriver = "/Users/dpm3354/working/DataStrategiesWorkspace/KylesWork/exampletests/src/main/resources/chromedriver";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		driver = new ChromeDriver();
		
		if (ResponseHandler.getResponseCode(baseUrl) != 200) {
			driver.close();
			fail("Did not get 200 response from site");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
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
		
		int rowCount = new InvoicesPage().getInvoiceCount(driver);		

		assertEquals(1, rowCount);
	}

}
