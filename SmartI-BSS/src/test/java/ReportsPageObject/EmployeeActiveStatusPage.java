package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.DropDownMethod;

public class EmployeeActiveStatusPage extends BasePage
{

	public EmployeeActiveStatusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//div[@title='Excel']//div[@class='button-outer']") WebElement Excelbtn;	
	@FindBy(xpath="//span[normalize-space()='Employee Activate Status']") WebElement EmployeeActiveStatus;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDFbtn;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> LocOptions;
	@FindBy(xpath="//div[@class='ui-widget-content slick-row even']//div[@class='slick-cell l0 r0'][normalize-space()='Thane']") WebElement SearchedLoc;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_DepartmentId']//b[@role='presentation']") WebElement DeptDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DeptOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l2 r2\"]") WebElement SearchedDept;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_DesignationId']//b[@role='presentation']") WebElement DesigDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DesigOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]") WebElement SearchedDesig;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DeviceOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l6 r6\"]") WebElement SearchedDevice;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_DeviceId']//b[@role='presentation']") WebElement DeviceDrop;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_ActivateStatus']//b[@role='presentation']") WebElement StatusDrop; 
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> StatusOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeActivateStatusGrid0_QuickFilter_EmployeeMasterID']//b[@role='presentation']") WebElement EmpMasterIdDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EmpMasterIdOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l7 r7\"]") WebElement SearchedStatus;
	
	DropDownMethod ddm = new DropDownMethod();
	
	//ActionMethods
	public void InitialSteps() {
		AccessManagment.click();
		Reports.click();
		Master.click();
		EmployeeActiveStatus.click();
	}
	
	//TS2217 - Verify exporting excel file
	 public void ExportExcelFile() {
		 InitialSteps();
		 Excelbtn.click();
	 }
	
	 //TS2218 - Verify exporting PDF file
		public void ExportPDFFile() {
			InitialSteps();
			PDFbtn.click();
		}
	
	//TS0129 - Location Filter Validation
	public void LocationFilter() throws InterruptedException {
		InitialSteps();
		LocDrop.click();
		ddm.selectFromDropdown(LocOptions, "Thane", "Location");
		Assert.assertTrue(SearchedLoc.getText().trim().equalsIgnoreCase("Thane"), "Location filter selection failed");
	}
	
	//TS0130 - Department Filter Validation
	public void DepartmentFilter() throws InterruptedException 
	{
		InitialSteps();
		DeptDrop.click();
		ddm.selectFromDropdown(DeptOptions, "Software Department", "Department");
		Thread.sleep(2000);
		Assert.assertTrue(SearchedDept.getText().trim().equalsIgnoreCase("Software Department"), "Department filter selection failed");
		
	}
	
	//TS0131 - Designation Filter Validation
	public void DesignationFilter() throws InterruptedException {
		InitialSteps();
		DesigDrop.click();
		ddm.selectFromDropdown(DesigOptions, "Account", "Designation");
		Thread.sleep(2000);
		Assert.assertTrue(SearchedDesig.getText().trim().equalsIgnoreCase("Account"), "Designation filter selection failed");
	}
	
	//TS0132 - Device Filter Validation
	public void DeviceFilter() throws InterruptedException{
		InitialSteps();
		DeviceDrop.click();
		ddm.selectFromDropdown(DeviceOptions, "TEST", "Device");
		Thread.sleep(2000);
		Assert.assertTrue(SearchedDevice.getText().trim().contains("TEST"), "Device filter selection failed");
	}
	
	//TS0133 - Status Filter Validation
	public void StatusFilter() throws InterruptedException {
		InitialSteps();
		StatusDrop.click();
		ddm.selectFromDropdown(StatusOptions, "Activated", "Status");
		Thread.sleep(2000);
		Assert.assertTrue(SearchedStatus.getText().trim().contains("Activated"), "Status filter selection failed");
	}
	
	/*
	//TS0133 - Employee master id Filter Validation
	public void EmployeeMasterId() throws InterruptedException
	{
		InitialSteps();
		EmpMasterIdDrop.click();
		ddm.selectFromDropdown(EmpMasterIdOptions, "Yash", "Employee Master ID");
		Thread.sleep(2000);
		Assert.assertTrue(SearchedDevice.getText().trim().contains("Yash"), "Employee Master ID filter selection failed");
	} */
	
	//
}
