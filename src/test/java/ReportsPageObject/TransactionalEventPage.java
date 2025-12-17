package ReportsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BasePage;

public class TransactionalEventPage extends BasePage {
	public TransactionalEventPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//span[normalize-space()='Transactional']") WebElement Transactional;
	@FindBy(xpath="//span[normalize-space()='Event']") WebElement Event;
	@FindBy(xpath="//div[@title='Excel']//div[@class='button-outer']") WebElement ExportExcelBtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement GeneratePDFBtn;
	
	//Action Methods
	public void InitialSteps()
	{
		AccessManagment.click();
		Reports.click();
		Transactional.click();
		Event.click();
	}
	
	//TS0157 - Export to Excel
	public void ExportToExcel() throws InterruptedException {
		InitialSteps();
		Thread.sleep(2000);
		ExportExcelBtn.click();
		Thread.sleep(10000);
	}
	
	//TS0158 - Generate PDF Report
	public void GeneratePDFReport() throws InterruptedException {
		InitialSteps();
		Thread.sleep(2000);
		GeneratePDFBtn.click();
		Thread.sleep(10000);
	}
	
}

