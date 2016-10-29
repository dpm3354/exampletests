package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvoicesPage {

	private static String invoicesTableXPath =     "//*[@id='content-wrapper']/div/div[2]/div/div/rd-widget/div/rd-widget-body/div/div/div/table";
	private static String invoicesTableRowsXPath = invoicesTableXPath + "/tbody/tr";

	private By invoicesTable = By.xpath(invoicesTableXPath);
	private By invoicesRows = By.xpath(invoicesTableRowsXPath);

	private WebElement getInvoicesTable(WebDriver driver){
		return driver.findElement(invoicesTable);
	}

	public int getInvoiceCount(WebDriver driver) {
		return driver.findElements(invoicesRows).size();
	}
}
