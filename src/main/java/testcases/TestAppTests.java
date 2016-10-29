package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.ResponseHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAppTests {
    private WebDriver driver;
    private static final String baseUrl = "http://52.55.130.111";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    
    
    
    
    

    @Before
    public void setUp() throws Exception {
    		System.setProperty("webdriver.chrome.driver", "/Users/dpm3354/working/DataStrategiesWorkspace/KylesWork/kyle_brueggy-testapp_testing-fc992548b8b7/src/main/resources/chromedriver");
    		driver = new ChromeDriver();
        
        if(ResponseHandler.getResponseCode(baseUrl) != 200){
        		driver.close();
        		fail("Did not get 200 response from site");
        }
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    

    

    @Test
    public void testTC1_UpdateAmountAndDescription() throws Exception {
        if (driver.findElement(By.linkText("Invoices")).isDisplayed()) {
        		System.out.println("Found Invoices!");
        }
        else{
        		System.out.println("Did not find Invoices!");
        }
        driver.findElement(By.linkText("Invoices")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (driver.findElement(By.linkText("Invoices")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(driver.findElement(By.linkText("10051")).isDisplayed());
        assertEquals("General Construction", driver.findElement(By.id("companyName_10051")).getText());
        assertEquals("215.00", driver.findElement(By.id("price_10051")).getText());
        assertEquals("Construction", driver.findElement(By.id("typeOfWork_10051")).getText());
        assertEquals("2016-04-11", driver.findElement(By.id("dueDate_10051")).getText());
        assertEquals("Installed new door frame.", driver.findElement(By.id("comment_10051")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10051")).getText());
        driver.findElement(By.linkText("10051")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (driver.findElement(By.xpath("//div[@id='cost_add']/input")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='cost_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='cost_add']/input")).sendKeys("250.00");
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).sendKeys("Installed new door frame. Installed locks.");
        driver.findElement(By.id("saveButton")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (driver.findElement(By.id("comment_10051")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("General Construction", driver.findElement(By.id("companyName_10051")).getText());
        assertEquals("250.00", driver.findElement(By.id("price_10051")).getText());
        assertEquals("Construction", driver.findElement(By.id("typeOfWork_10051")).getText());
        assertEquals("2016-04-11", driver.findElement(By.id("dueDate_10051")).getText());
        assertEquals("Installed new door frame. Installed locks.", driver.findElement(By.id("comment_10051")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10051")).getText());
    }

    @Test
    public void testTC2_UpdateInvoiceStatus() throws Exception {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("Invoices")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Invoices")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("Invoices")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(driver.findElement(By.linkText("10051")).isDisplayed());
        assertEquals("General Construction", driver.findElement(By.id("companyName_10051")).getText());
        assertEquals("215.00", driver.findElement(By.id("price_10051")).getText());
        assertEquals("Construction", driver.findElement(By.id("typeOfWork_10051")).getText());
        assertEquals("2016-04-11", driver.findElement(By.id("dueDate_10051")).getText());
        assertEquals("Installed new door frame.", driver.findElement(By.id("comment_10051")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10051")).getText());
        driver.findElement(By.linkText("10051")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.xpath("//div[@id='cost_add']/input")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        new Select(driver.findElement(By.id("selectStatus"))).selectByVisibleText("Sent");
        driver.findElement(By.id("saveButton")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.id("status_10051")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("General Construction", driver.findElement(By.id("companyName_10051")).getText());
        assertEquals("Construction", driver.findElement(By.id("typeOfWork_10051")).getText());
        assertEquals("215.00", driver.findElement(By.id("price_10051")).getText());
        assertEquals("Sent", driver.findElement(By.id("status_10051")).getText());
        assertEquals("2016-04-11", driver.findElement(By.id("dueDate_10051")).getText());
        assertEquals("Installed new door frame.", driver.findElement(By.id("comment_10051")).getText());
        assertEquals("Construction", driver.findElement(By.id("typeOfWork_10051")).getText());
    }

    @Test
    public void testTC3_CreateInvoiceAndUpdate() throws Exception {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("Invoices")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Invoices")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("Invoices")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertFalse(isElementPresent(By.linkText("10053")));
        driver.findElement(By.linkText("Add Invoice")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // Create Invoice
        driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).sendKeys("10053");
        driver.findElement(By.xpath("//div[@id='compName_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='compName_add']/input")).sendKeys("All Day Plumbing");
        driver.findElement(By.xpath("//div[@id='typeofwork_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='typeofwork_add']/input")).sendKeys("Plumbing");
        driver.findElement(By.xpath("//div[@id='cost_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='cost_add']/input")).sendKeys("75.00");
        new Select(driver.findElement(By.id("selectStatus"))).selectByVisibleText("Draft");
        driver.findElement(By.xpath("//div[@id='invoice_dueDate']/input")).clear();
        driver.findElement(By.xpath("//div[@id='invoice_dueDate']/input")).sendKeys("2016-04-30");
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).sendKeys("Installed toilet handle.");
        driver.findElement(By.id("createButton")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("10053")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("All Day Plumbing", driver.findElement(By.id("companyName_10053")).getText());
        assertEquals("Plumbing", driver.findElement(By.id("typeOfWork_10053")).getText());
        assertEquals("75.00", driver.findElement(By.id("price_10053")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10053")).getText());
        assertEquals("2016-04-30", driver.findElement(By.id("dueDate_10053")).getText());
        assertEquals("Installed toilet handle.", driver.findElement(By.id("comment_10053")).getText());
        driver.findElement(By.linkText("10053")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.cssSelector("#invoice_dueDate")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='comments_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).sendKeys("Installed toilet handle in master bedroom.");
        driver.findElement(By.id("saveButton")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.linkText("10053")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("All Day Plumbing", driver.findElement(By.id("companyName_10053")).getText());
        assertEquals("Plumbing", driver.findElement(By.id("typeOfWork_10053")).getText());
        assertEquals("75.00", driver.findElement(By.id("price_10053")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10053")).getText());
        assertEquals("2016-04-30", driver.findElement(By.id("dueDate_10053")).getText());
        assertEquals("Installed toilet handle in master bedroom.", driver.findElement(By.id("comment_10053")).getText());
    }

    @Test
    public void testTC4_CreateInvoiceThenDelete() {
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            if (driver.findElement(By.linkText("Invoices")).isDisplayed()) {
                break;
            }
        }

        driver.findElement(By.linkText("Invoices")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            if (driver.findElement(By.linkText("Invoices")).isDisplayed()) {
                break;
            }
        }
        assertFalse(isElementPresent(By.linkText("10053")));

        driver.findElement(By.linkText("Add Invoice")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            if (driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).isDisplayed()) {
                break;
            }
        }

        driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='invoiceNo_add']/input")).sendKeys("10053");
        driver.findElement(By.xpath("//div[@id='compName_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='compName_add']/input")).sendKeys("All Day Plumbing");
        driver.findElement(By.xpath("//div[@id='typeofwork_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='typeofwork_add']/input")).sendKeys("Plumbing");
        driver.findElement(By.xpath("//div[@id='cost_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='cost_add']/input")).sendKeys("75.00");
        new Select(driver.findElement(By.id("selectStatus"))).selectByVisibleText("Draft");
        driver.findElement(By.xpath("//div[@id='invoice_dueDate']/input")).clear();
        driver.findElement(By.xpath("//div[@id='invoice_dueDate']/input")).sendKeys("2016-04-30");
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).clear();
        driver.findElement(By.xpath("//div[@id='comments_add']/input")).sendKeys("Installed toilet handle.");
        driver.findElement(By.id("createButton")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            if (driver.findElement(By.linkText("10053")).isDisplayed()) {
                break;
            }
        }

        assertEquals("All Day Plumbing", driver.findElement(By.id("companyName_10053")).getText());
        assertEquals("Plumbing", driver.findElement(By.id("typeOfWork_10053")).getText());
        assertEquals("75.00", driver.findElement(By.id("price_10053")).getText());
        assertEquals("Draft", driver.findElement(By.id("status_10053")).getText());
        assertEquals("2016-04-30", driver.findElement(By.id("dueDate_10053")).getText());
        assertEquals("Installed toilet handle.", driver.findElement(By.id("comment_10053")).getText());
        driver.findElement(By.linkText("10053")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            if (driver.findElement(By.cssSelector("#invoice_dueDate")).isDisplayed()) {
                break;
            }
        }

        driver.findElement(By.id("deleteButton")).click();

        assertFalse(isElementPresent(By.linkText("10053")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
