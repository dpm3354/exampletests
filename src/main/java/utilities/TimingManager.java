package utilities;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class TimingManager {
	
	public static void waitForPageLoad(WebDriver driver, String subString) {
		int counter = 0;
		int interval = 100;
		int maxCount = 5;
		String url = driver.getCurrentUrl();
		while (url.contains(subString) && counter++ < maxCount) {
			try {
				Thread.sleep(interval);
				url = driver.getCurrentUrl();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (UnhandledAlertException e){
				fail(e.getMessage());
			}
		}
		
	}

	public static void wait(int nanos) {

		try {
			Thread.sleep(nanos);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

}
