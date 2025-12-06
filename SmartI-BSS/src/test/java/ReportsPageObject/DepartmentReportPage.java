package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.DropDownMethod;

public class DepartmentReportPage extends BasePage {
	// Constructor
	public DepartmentReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//a[@href='/Master/Department/DepartmentMaster']//span[contains(text(),'Department')]") WebElement Department;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement Excelbtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDFbtn;
	@FindBy(xpath = "//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement Searchbar;
	@FindBy(xpath="//div[@class=\"slick-cell l3 r3\"]") WebElement SearchResultDept;
	@FindBy(xpath="//div[@class=\"slick-cell l2 r2\"]") WebElement SearchResultCode;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DivisionOptions; 
	@FindBy(xpath="//b[@role='presentation']") WebElement DivisionDrop;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]") WebElement SearchResultDivi;
	DropDownMethod dd = new DropDownMethod();
	
	//Action Methods
	public void InitialStep() {
		AccessManagment.click();
		Reports.click();
		Master.click();
		Department.click();
	}
	
	//TS0100 - Export to Excel
	public void ExportExcel() throws InterruptedException {
		InitialStep();
		Excelbtn.click();
		Thread.sleep(10000);
	}

	//TS0101 - Export to PDF
	public void ExportPDF() throws InterruptedException {
		InitialStep();
		PDFbtn.click();
		Thread.sleep(10000);
	}
	
	//TS0102 - Search Department by Code or Name
	public void VerifySearch(String Dept, String DeptCode) throws InterruptedException {
		InitialStep();
		Searchbar.sendKeys(Dept);
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultDept.getText().contains(Dept), "Search is not working");
		Searchbar.clear();
		Searchbar.sendKeys(DeptCode);
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultCode.getText().contains(DeptCode), "Search is not working");
	}
	
	//TS0103 - verify Division Filter of the Department form
	public void VerifyDivisionFilter() throws InterruptedException {
		InitialStep();
		DivisionDrop.click();
		dd.selectFromDropdown(DivisionOptions,"Division B", "Division");
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultDivi.getText().contains("Division B"), "Division Filter is not working");
	}
}

