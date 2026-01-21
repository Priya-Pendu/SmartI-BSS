package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DatePickerUtil;
import Utilities.DropDownMethod;

public class TransactionalAccessPage extends BasePage {

	public TransactionalAccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//span[normalize-space()='Transactional']") WebElement Transactional;
	@FindBy(xpath="//a[@href='/Reports/AccessReport']") WebElement AccessReport;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> LocOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l3 r3\"]") WebElement LocationResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_DepartmentId']//b[@role='presentation']") WebElement DeptDrop; 
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DeptOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l4 r4\"]") WebElement DepartmentResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_EmployeeMasterID']//b[@role='presentation']") WebElement EmpDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]") List<WebElement> EmpOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l7 r7\"]") WebElement EmployeeResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_DeviceLocationId']//b[@role='presentation']") WebElement DevLocDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]") List<WebElement> DevLocOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l8 r8\"]") WebElement DeviceLocationResult;
	@FindBy(xpath="//a[@class='select2-choice']//span[@role='presentation']") WebElement DevDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> DevOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l9 r9\"]") WebElement DeviceResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_ReaderID']//b[@role='presentation']") WebElement ReaderDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> ReaderOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l10 r10\"]") WebElement ReaderResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_EventMessageID']//b[@role='presentation']") WebElement EventDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EventOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l11 r11\"]") WebElement EventResult;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_EmployeesType']//b[@role='presentation']") WebElement EmpTypeDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> EmpTypeOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]") WebElement EmpTypeResult;
	@FindBy(xpath="//@select[@class=\"editor s-DateTimeEditor time\"]/*") List<WebElement> TimeOptions;
	@FindBy(xpath="//div[@class='grid-toolbar s-Serenity-Toolbar s-Toolbar clearfix']//select[1]") WebElement fromtimepicker;
	@FindBy(xpath="//div[@class='content-wrapper']//img[1]") WebElement FromDatePicker;
	@FindBy(xpath="//img[2]") WebElement ToDatePicker;
	@FindBy(xpath="//select[2]") WebElement totimepicker;
	
	
	DropDownMethod ddm = new DropDownMethod();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	DatePickerUtil dtp = new DatePickerUtil();
	
	//Action Method
	public void InitialStep()
	{
		AccessManagment.click();
		Reports.click();
		Transactional.click();
		AccessReport.click();
	}
	
	//Location Filter Validation
	public void LocationFilter(String location) {
		logger.info("Initial step started");
		InitialStep();
		
		logger.info("Location Drop down clicked");
		LocDrop.click();
		
		logger.info("Selecting location from the drop down");
		ddm.selectFromDropdown(LocOptions, "Mumbai", location);
		
		logger.info("Verify the result of choosing location.");
		Assert.assertTrue(LocationResult.getText().contains(location), "Location Filter not working");
	}
	
	//TS0148 - Department Filter Validation
	public void DepartmentFilter(String department)
	{
		logger.info("Initial step started");
		InitialStep();
		
		logger.info("Department Drop down clicked");
		DeptDrop.click();
		
		logger.info("Selecting department from the drop down");
		ddm.selectFromDropdown(DeptOptions, "Software Department", department);
		
		logger.info("Verify the result of choosing department.");
		Assert.assertTrue(DepartmentResult.getText().contains(department), "Department Filter not working");
	}
	
	//TS0149 - Employee Filter Validation
	public void EmployeeFilter(String employee) {
		logger.info("Initial step started");
		InitialStep();

		logger.info("Employee Drop down clicked");
		EmpDrop.click();

		logger.info("Selecting employee from the drop down");
		ddm.selectFromDropdown(EmpOptions, "Shreya Sharma", employee);

		logger.info("Verify the result of choosing employee.");
		Assert.assertTrue(EmployeeResult.getText().contains(employee), "Employee Filter not working");
	
	}
	
	//TS0150 - Device Location Filter Validation
	public void DeviceLocationFilter(String devicelocation) throws InterruptedException {
		logger.info("Initial step started");
		InitialStep();

		logger.info("Device Location Drop down clicked");
		DevLocDrop.click();

		Thread.sleep(2000);
		logger.info("Selecting device location from the drop down");
		ddm.selectFromDropdown(DevLocOptions, "Mumbai", devicelocation);

		logger.info("Verify the result of choosing device location.");
		Assert.assertTrue(DeviceLocationResult.getText().contains(devicelocation),
		"Device Location Filter not working");
	}
	
	//TS0151 - Device Filter Validation
	public void DeviceFilter(String device) {
		logger.info("Initial step started");
		InitialStep();

		logger.info("Device Drop down clicked");
		driver.findElement(By.cssSelector(".select2-choice")).click();

		logger.info("Selecting device from the drop down");
		ddm.selectFromDropdown(DevOptions, "BioSlim12", device);

		logger.info("Verify the result of choosing device.");
		Assert.assertTrue(DeviceResult.getText().contains(device), "Device Filter not working");

	}
	
	
	//TS0152 - Reader Filter Validation
	public void ReaderFilter(String reader) throws InterruptedException
	{
		logger.info("Initial step started");
		InitialStep();
		
		logger.info("Reader Drop down clicked");
		ReaderDrop.click();
		
		logger.info("Selecting reader from the drop down");
		ddm.selectFromDropdown(ReaderOptions, "BioSlim Reader 1", "Reader1");
		
		logger.info("Verify the result of choosing reader.");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
		Thread.sleep(2000);

		Assert.assertTrue(ReaderResult.getText().contains(reader), "Reader Filter not working");
	}
	
	
	//TS0153 - Event Filter Validation
	public void EventFilter(String event) throws InterruptedException
    {
        logger.info("Initial step started");
        InitialStep();
        
        logger.info("Event Drop down clicked");
        EventDrop.click();
        
        logger.info("Selecting event from the drop down");
        ddm.selectFromDropdown(EventOptions, "ACCESS GRANTED", event);
        
        logger.info("scroll to right"); 
        js.executeScript("window.scrollBy(5000,0)");
        
        logger.info("Verify the result of choosing event.");
        Assert.assertTrue(EventResult.getText().contains("ACCESS GRANTED"), "Event Filter not working");  
        
    }


	//TS0154 - Employee type Filter Validation
	public void EmployeeTypeFilter(String EmpType) throws InterruptedException
	{
		logger.info("Initial step started");
		InitialStep();

		logger.info("Employee Type Drop down clicked");
		wait.until(ExpectedConditions.visibilityOf(EmpTypeDrop));
		EmpTypeDrop.click();

		logger.info("Selecting Employee Type from the drop down");
		ddm.selectFromDropdown(EmpTypeOptions, "Internal Employee", "Employee Type");

		logger.info("Verify the result of choosing Employee Type.");
		Assert.assertTrue(EmpTypeResult.getText().contains(EmpType), "Employee Type Filter not working");
	}
	
	//TS0155 - from date & time and to date & time filter validation
	public void FromToDateTimeFilter() throws InterruptedException 
	{
			
		logger.info("Initial step started");
		InitialStep();

		logger.info("Click on From Date picker");
		FromDatePicker.click();
		
		logger.info("From Date selection started");
		DatePickerUtil.selectDate(
		        driver,
		        By.id("BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_TransactionDate"),
		        "1",
		        "Jan",
		        "2026"
		);
    

		logger.info("click on from time picker");
		fromtimepicker.click();
		
		logger.info("From Time selection started");
		ddm.selectFromDropdown(TimeOptions , "12:00", "Date");

		logger.info("Click on To Date picker");
		ToDatePicker.click();
		
		logger.info("To Date selection started");
		DatePickerUtil.selectDate(
		        driver,
		        By.id("BuildingSolutionSuite_Reports_AccessReportGrid0_QuickFilter_TransactionDate"),
		        "1",
		        "Jan",
		        "2026"
		);
		
		logger.info("Click on To Time picker");
		totimepicker.click();
		
		logger.info("From Date & Time and To Date & Time filter applied successfully");
		ddm.selectFromDropdown(DeptOptions, "22:00", "Date");
	}

	
}
