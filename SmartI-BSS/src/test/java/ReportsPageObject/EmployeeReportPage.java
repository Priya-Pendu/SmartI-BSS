package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.DropDownMethod;

public class EmployeeReportPage extends BasePage{

	public EmployeeReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement Excel;
	@FindBy(xpath="//a[@href='/Reports/ViewMasterEmployeeMaster']//span[contains(text(),'Employees')]") WebElement Employee;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDF;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_ViewMasterEmployeeMasterGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List <WebElement> LocationOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]") WebElement LocFilterResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_ViewMasterEmployeeMasterGrid0_QuickFilter_IsBlackListed']//b[@role='presentation']") WebElement BlackDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> BlackListOptions; 
	
	DropDownMethod DD = new DropDownMethod();
	
	//Action Methods
	public void InitialSteps()
	{
		AccessManagment.click();
		Reports.click();
		Master.click();
		Employee.click();
	}
	
	//TS0109 - Export to Excel
	public void ExportExcel() throws InterruptedException
	{
		InitialSteps();
		Excel.click();
		Thread.sleep(10000);
	}
	
	//TS0110 - Generate PDF Report
	public void ExportPDF() throws InterruptedException
	{
		InitialSteps();
		PDF.click();
		Thread.sleep(10000);
	}
	
	
	
	//TS0112 - check based on location filter data gets filtered or not
	public void LocationFilterValidation() throws InterruptedException
	{
		InitialSteps();
		BlackDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(BlackListOptions, "Yes", "Is Black Listed");
		Thread.sleep(2000);
		Assert.assertTrue(LocFilterResult.getText().contains("Mumbai"), "Department filter is not working as expected");	
	}
}
