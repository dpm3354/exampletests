package pageobjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import db.InvoiceData;
import utilities.TimingManager;

public class AddInvoicePage {
	
	public static By invoiceNoDivInput = By.xpath("//div[@id='invoiceNo_add']/input");
	public static By companyNameDivInput = By.xpath("//div[@id='compName_add']/input");
	public static By typeOfWorkDivInput = By.xpath("//div[@id='typeofwork_add']/input");
	public static By costDivInput = By.xpath("//div[@id='cost_add']/input");
	public static By selectStatusSelect = By.id("selectStatus");
	public static By dueDateDivInput = By.xpath("//div[@id='invoice_dueDate']/input");
	public static By commentsDivInput = By.xpath("//div[@id='comments_add']/input");
	public static By createButton = By.id("createButton");
	public static By addInvoiceLink = By.linkText("Add Invoice");
	
	public void createInvoice(WebDriver driver) {

		// add an invoice
		// hardcoded
		InvoiceData invoice = new InvoiceData("10030", "All Day Plumbing", "Plumbing", "75.00", "Draft", 
				"2016-04-30", "Installed toilet handle.");
		
		createInvoice(driver, invoice);
	}

	public void clickAddInvoice(WebDriver driver) {
		driver.findElement(addInvoiceLink).click();		
	}

	public void createInvoice(WebDriver driver, InvoiceData invoice) {
		clickAddInvoice(driver);		
		driver.findElement(invoiceNoDivInput).clear();
		driver.findElement(invoiceNoDivInput).sendKeys(invoice.getInvoiceNumber());
		
		driver.findElement(companyNameDivInput).clear();
		driver.findElement(companyNameDivInput).sendKeys(invoice.getCompanyName());
		
		driver.findElement(typeOfWorkDivInput).clear();
		driver.findElement(typeOfWorkDivInput).sendKeys(invoice.getTypeOfWork());
		
		driver.findElement(costDivInput).clear();
		driver.findElement(costDivInput).sendKeys(invoice.getAmount());
		
		new Select(driver.findElement(selectStatusSelect)).selectByVisibleText(invoice.getStatus());
		
		driver.findElement(dueDateDivInput).clear();
		driver.findElement(dueDateDivInput).sendKeys(invoice.getDueDate());
		
		driver.findElement(commentsDivInput).clear();
		driver.findElement(commentsDivInput).sendKeys(invoice.getDescription());
		
		driver.findElement(createButton).click();
		TimingManager.waitForPageLoad(driver, "addInvoice");		
		TimingManager.wait(500);	
	}
}
