package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Configuration;

public class InvoiceTests {
	
	protected WebDriver driver;
	protected static final String baseUrl = "http://"+Configuration.applicationIp;
	protected static final String pathToChromeDriver = Configuration.pathToChromeDriver;

	public void setUp(){
//		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
