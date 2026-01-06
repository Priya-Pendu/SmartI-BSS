package ReportsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.BasePage;

public class DesignationReportPage extends BasePage {
	// Constructor
	public DesignationReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//a[@href='/Master/Designation/DesignationMaster']//span[contains(text(),'Designation')]") WebElement Designation;
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement Searchbar;
	@FindBy(xpath="//div[@class='slick-cell l1 r1']") WebElement SearchResultDesig;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement Excelbtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDFbtn;
	
	//Action Methods
	public void InitialStep() {
		AccessManagment.click();
		Reports.click();
		Master.click();
		Designation.click();
	}
	
	//TS0095 - Search Designation
	public void VerifySearch(String Desig) throws InterruptedException
	{
		logger.info("Initial Steps started");
		InitialStep();
		
		logger.info("Designation sent on search bar");
		Searchbar.sendKeys(Desig);
		
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultDesig.getText().contains(Desig), "Search Designation Failed");
	}
	
	//TS0096 - Export to Excel Report
	public void ExportExcel() throws InterruptedException {
		logger.info("Initial Steps started");
		InitialStep();
		
		logger.info("Clicking on Excel Button");
		Excelbtn.click();
		Thread.sleep(10000);
	}
	
	//TS0097 - Export to PDF Report
	public void ExportPDF() throws InterruptedException {
		logger.info("Initial Steps started");
		InitialStep();
		PDFbtn.click();
		Thread.sleep(10000);
	}
}
