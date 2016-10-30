package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Configuration;

public class InvoiceTests {
	
	protected WebDriver driver;
	protected static final String baseUrl = "http://"+Configuration.applicationIp;
	protected static final String pathToChromeDriver = "/Users/dpm3354/working/DataStrategiesWorkspace/KylesWork/exampletests/src/main/resources/chromedriver";

	public void setUp(){
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
