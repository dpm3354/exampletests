package pageobjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddInvoicePage {
	
	public static By invoiceNoDivInput = By.xpath("//div[@id='invoiceNo_add']/input");
	public static By companyNameDivInput = By.xpath("//div[@id='compName_add']/input");
	public static By typeOfWorkDivInput = By.xpath("//div[@id='typeofwork_add']/input");
	public static By costDivInput = By.xpath("//div[@id='cost_add']/input");
	public static By selectStatusSelect = By.id("selectStatus");
	public static By dueDateDivInput = By.xpath("//div[@id='invoice_dueDate']/input");
	public static By commentsDivInput = By.xpath("//div[@id='comments_add']/input");
	public static By createButton = By.id("createButton");
	
	public void createInvoice(WebDriver driver) {
		// add an invoice
		driver.findElement(invoiceNoDivInput).clear();

		// these have to change for elementary strategy
		// int invoiceNumber = ThreadLocalRandom.current().nextInt(10000, 10200);

		// hardcoded
		int invoiceNumber = 10030;
		driver.findElement(invoiceNoDivInput).sendKeys(Integer.toString(invoiceNumber));

		driver.findElement(companyNameDivInput).clear();
		driver.findElement(companyNameDivInput).sendKeys("All Day Plumbing");
		driver.findElement(typeOfWorkDivInput).clear();
		driver.findElement(typeOfWorkDivInput).sendKeys("Plumbing");
		driver.findElement(costDivInput).clear();
		driver.findElement(costDivInput).sendKeys("75.00");
		new Select(driver.findElement(selectStatusSelect)).selectByVisibleText("Draft");
		driver.findElement(dueDateDivInput).clear();
		driver.findElement(dueDateDivInput).sendKeys("2016-04-30");
		driver.findElement(commentsDivInput).clear();
		driver.findElement(commentsDivInput).sendKeys("Installed toilet handle.");
		driver.findElement(createButton).click();
	}
}
