package ReportsPageObject;


import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;

public class EmployeeEntityAccessPage extends BasePage
{

	public EmployeeEntityAccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='Employee Entity Access']") WebElement EmployeeEntityAccess;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> LocDropValues;
	@FindBy(xpath="//div[@class='slick-cell l0 r0']") WebElement LocResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_DepartmentId']//b[@role='presentation']") WebElement DeptDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DeptDropValues;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_EmployeeMasterID']//b[@role='presentation']") WebElement EmpDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EmpDropValues;
	@FindBy(xpath="//div[@class=\"slick-cell l5 r5\"]") WebElement EmpResult;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement ExportToExcelBtn;
	@FindBy(xpath ="//div[@title='PDF']//span[@class='button-inner']") WebElement GeneratePDFBtn;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_DesignationId']//b[@role='presentation']") WebElement DesigDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DesigDropValues;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]") WebElement DesigResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_EntityId']//b[@role='presentation']") WebElement EntityDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EntityDropValues;
	@FindBy(xpath="//div[@class=\"slick-cell l6 r6\"]") WebElement EntityResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessEmployeeEntityAccessGrid0_QuickFilter_EmployeesType']//b[@role='presentation']") WebElement EmpTypeDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") WebElement EmpTypeDropValues;
	
	DropDownMethod ddm = new DropDownMethod();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//ActionMethods
	public void InitialSteps() throws InterruptedException {
		AccessManagment.click();
		Reports.click();
		Master.click();
		js.executeScript("arguments[0].scrollIntoView(true);", EmployeeEntityAccess);
		Thread.sleep(1000);
		EmployeeEntityAccess.click();
	}
	
	//TS0136 - Export to Excel
	public void ExportToExcel() throws InterruptedException {
		InitialSteps();
		ExportToExcelBtn.click();
		Thread.sleep(10000);
		// To be implemented
		logger.info("TS0136 - Export to Excel is completed");
	}
	
	//TS0137 - Generate PDF Report
	public void GeneratePDFReport() throws InterruptedException {
		InitialSteps();
		GeneratePDFBtn.click();
		Thread.sleep(10000);
		// To be implemented
		logger.info("TS0137 - Generate PDF Report is completed");
	}
	
	//TS0138 - Location Filter Validation
	public void LocationFilterValidation() throws InterruptedException {
		InitialSteps();
		Thread.sleep(2000);
		LocDrop.click();
		ddm.selectFromDropdown(LocDropValues, "Thane", "Employee Entity Access");
		Thread.sleep(2000);
		Assert.assertTrue(LocResult.getText().contains("Thane"), "Location Filter is not working properly");
		logger.info("TS0147 - Location Filter Validation is completed");
	}
	
	//TS0139 - Department Filter Validation
	public void DepartmentFilterValidation() throws InterruptedException {
		InitialSteps();
		Thread.sleep(2000);
		DeptDrop.click();
		ddm.selectFromDropdown(DeptDropValues, "Sales Department", "Department");
		logger.info("TS0148 - Department Filter Validation is completed");
	}
	
	//TS0140 - Designation Filter Validation
	public void DesignationFilterValidation() throws InterruptedException {
		InitialSteps();
		DesigDrop.click();
		ddm.selectFromDropdown(DesigDropValues, "Software Tester", "Designation");
        Thread.sleep(2000);
        Assert.assertTrue(DesigResult.getText().contains("Software Tester"), "Designation Filter is not working properly");
		logger.info("TS0140 - Designation Filter Validation is completed");
	}
	
	//TS0141 - Entity Filter Validation
	public void EntityFilterValidation() throws InterruptedException {
		InitialSteps();
		EntityDrop.click();
		ddm.selectFromDropdown(EntityDropValues, "All Access", "Entity");
		Thread.sleep(2000);
		Assert.assertTrue(EntityResult.getText().contains("All Access"), "Entity Filter is not working properly");
		logger.info("TS0141 - Entity Filter Validation is completed");
	}
	
	//TS0142 - Employee Filter Validation
	public void EmployeeFilterValidation() throws InterruptedException {
		InitialSteps();
		EmpDrop.click();
		ddm.selectFromDropdown(EmpDropValues, "Gomtesh Khot", "Employee");
		Thread.sleep(2000);
		Assert.assertTrue(EmpResult.getText().contains("Gomtesh Khot"), "Employee Filter is not working properly");
		logger.info("TS0149 - Employee Filter Validation is completed");
	}
	
	
}
