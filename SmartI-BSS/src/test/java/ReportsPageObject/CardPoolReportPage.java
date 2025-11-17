package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.DropDownMethod;

public class CardPoolReportPage extends BasePage {

	
	public CardPoolReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='CardPool']") WebElement CardPool;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]") List<WebElement> LocationOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]") WebElement LocationResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_DepartmentId']//b[@role='presentation']") WebElement DeptDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]") List<WebElement> DepartmentOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l9 r9\"]") WebElement DepartmentResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_DesignationId']//b[@role='presentation']") WebElement DesigDrop;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*") List<WebElement> DesignationOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l8 r8\"]") WebElement DesignationResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_EmployeeMasterID']//b[@role='presentation']") WebElement EmpDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EmployeeOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l7 r7\"]") WebElement EmployeeResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_CardStatus']//b[@role='presentation']") WebElement CardStatusDrop;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*") List<WebElement> CardStatusOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l2 r2\"]") WebElement StatusResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_CardTypeID']//b[@role='presentation']") WebElement CardTypeDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> CardTypeOption;
	@FindBy(xpath="//div[@class=\"slick-cell l4 r4\"]") WebElement CardTypeResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_EmployeesType']//b[@role='presentation']") WebElement EmpTypeDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EmpTypeOptions;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement Excel;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDF;
	
	
	DropDownMethod DD = new DropDownMethod();
	
	//Action Method
	public void Initialstep()
	{
		AccessManagment.click();
		Reports.click();
		Master.click();
		CardPool.click();
	}
	
	//TS0118 - Location Filter Validation
	public void LocationFilterValidation() throws InterruptedException {
		Initialstep();
		LocDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(LocationOptions, "Kalyan", "Location");
		Thread.sleep(2000);
		Assert.assertTrue(LocationResult.getText().contains("Kalyan"), "Location filter is not working as expected");
	}
	
	//TS0119 - Department Filter Validation
	public void DepartmentFilterValidation() throws InterruptedException {
		Initialstep();
		DeptDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(DepartmentOptions, "Software Department", "Department");
		Thread.sleep(2000);
		Assert.assertTrue(DepartmentResult.getText().contains("Software Department"), "Department filter is not working as expected");
	}
	
	//TS0120 - Designation Filter Validation
	public void DesignationFilterValidation() throws InterruptedException {
		Initialstep();
	    DesigDrop.click();
	    Thread.sleep(2000);
	    DD.selectFromDropdown(DesignationOptions, "Software Tester", "Designation");
	    Thread.sleep(2000);
	    Assert.assertTrue(DesignationResult.getText().contains("Software Tester"), "Designation filter is not working as expected");
	}
	
	//TS0121 - Employee Filter Validation
	public void EmployeeFilterValidation() throws InterruptedException {
		Initialstep();
		EmpDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(EmployeeOptions, "Gomtesh Khot", "Employee");
		Thread.sleep(2000);
		Assert.assertTrue(EmployeeResult.getText().contains("Gomtesh Khot"), "Employee filter is not working as expected");
	}
	
	//TS0122 - Card Status Filter Validation
	public void CardStatusValidation() throws InterruptedException
	{
		Initialstep();
		CardStatusDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(CardStatusOptions, "Assigned", "Card Status");
		Thread.sleep(2000);
		Assert.assertTrue(StatusResult.getText().contains("Assigned"), "Card Status filter is not working as expected");
		
	}
	
	//TS0123 - card type filter validation
	public void CardTypeValidation() throws InterruptedException
	{
		Initialstep();
		CardTypeDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(CardTypeOption, "Regular", "Card Type");
		Thread.sleep(2000);
		Assert.assertTrue(CardTypeResult.getText().contains("Regular"), "Card Status filter is not working as expected");
	}
	
	
	//TS0124 - employee type filter validation
	public void EmpTypeValidation() throws InterruptedException
	{
		Initialstep();
		EmpTypeDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(EmpTypeOptions, "Regular", "Card Type");
		Thread.sleep(2000);
		Assert.assertTrue(CardTypeResult.getText().contains("Regular"), "Card Status filter is not working as expected");
	}
	
	//TS0125 - Export to Excel
	public void ExportExcel() throws InterruptedException
	{
		Initialstep();
		Excel.click();
		Thread.sleep(10000);
	}
	
	//TS0126 - Generate PDF Report
	public void ExportPDF() throws InterruptedException
	{
		Initialstep();
		PDF.click();
		
		Thread.sleep(10000);
	}
}
