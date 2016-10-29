package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pageobjects.AddInvoicePage;
import utilities.ResponseHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementaryStrategyTests {
	private WebDriver driver;
	private static final String baseUrl = "http://52.55.130.111";
	private static final String pathToChromeDriver = "/Users/dpm3354/working/DataStrategiesWorkspace/KylesWork/kyle_brueggy-testapp_testing-fc992548b8b7/src/main/resources/chromedriver";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

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
	public void addInvoice() {
		driver.findElement(By.linkText("Add Invoice")).click();
		new AddInvoicePage().createInvoice(driver);

		int counter = 0;
		String url = driver.getCurrentUrl();
		while (url.contains("addInvoice") && counter++ < 5) {
			try {
				Thread.sleep(100);
				url = driver.getCurrentUrl();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		WebElement table = driver.findElement(By
				.xpath("//*[@id='content-wrapper']/div/div[2]/div/div/rd-widget/div/rd-widget-body/div/div/div/table"));
		int rowCount = driver
				.findElements(By.xpath("//*[@id='content-wrapper']/div/div[2]/div/div/rd-widget/div/rd-widget-body/div/div/div/table/tbody/tr"))
				.size();

		assertEquals(1, rowCount);
	}



}
