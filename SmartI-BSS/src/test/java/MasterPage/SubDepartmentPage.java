package MasterPage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import LoginTest.LoginPage;
import Utilities.BasePage;
import Utilities.DropDownMethod;


public class SubDepartmentPage extends BasePage
{
	WebDriver driver;
	
	
	//Constructor
	public SubDepartmentPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath ="//p[@class='title-text'][contains(text(),'Access')]") WebElement AccessManagement;
	@FindBy(xpath="/html[1]/body[1]/div[2]/aside[1]/section[1]/div[1]/ul[1]/li[3]/a[1]") WebElement Master;
	@FindBy(xpath ="//span[normalize-space()='SubDepartment']") WebElement SubDepartment;
	@FindBy(xpath ="//span[normalize-space()='New Sub Department']") WebElement NewDept;
	@FindBy(xpath ="//b[@role='presentation']") WebElement Dpartdrop;
	@FindBy(xpath ="//div[@id='select2-drop']/*") List<WebElement> DpartOptions;
	@FindBy(id="s2id_autogen1_search") WebElement DepartmentName;
	@FindBy(id ="BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentCode") WebElement SubDCode;
	@FindBy(id ="BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentName") WebElement SubDName;
	@FindBy(xpath = "//textarea[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_AuditRemark']") WebElement Audit;
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement Save;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrow;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement ok;
	//Edit Sub Department Locators
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']" )
	WebElement EditSearchDepart;
	@FindBy(xpath="//div[@class='slick-cell l3 r3']/a")
	WebElement EditSubDName;
	@FindBy(xpath="//b[@role='presentation']")
	WebElement EditDeptDrop;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']")
	WebElement EditSDeptName;
	//input[@id='s2id_autogen1_search']
	//input[@id='s2id_autogen1_search']
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List <WebElement> EditDeptOptions;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentCode']")
	WebElement EditCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentName']")
	WebElement EditName;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement EditSaveApply;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement EditBackArrow;
	@FindBy(xpath="//div[@class='panel-titlebar']")
	WebElement NewSubDepartPage;
	@FindBy(xpath="//div[@class=\"slick-cell l3 r3\"]/a")
	List<WebElement> SubDeptList; 
	@FindBy(xpath="//span[@id='select2-chosen-1']")
	WebElement SelectedDept;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentCode']")
	WebElement ViewSubDCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_SubDepartmentName']")
	WebElement ViewSubDName;
	@FindBy(xpath="//textarea[@id='BuildingSolutionSuite_Master_SubDepartmentDialog8_AuditRemark']")
	WebElement ViewAuditRemark;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']")
	WebElement ExcelExport;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']")
	WebElement PDFExport;
	@FindBy(xpath="//div[@class=\"slick-cell l3 r3\"]")
	WebElement SearchResultName;
	@FindBy(xpath="//div[normalize-space()='200']")
	WebElement SearchResultCode;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement Profile;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout;
	@FindBy(id = "BuildingSolutionSuite_Membership_LoginPanel0_Username") 
	WebElement User;
	@FindBy(id="BuildingSolutionSuite_Membership_LoginPanel0_Password") 
	WebElement Pass;
	@FindBy(id ="BuildingSolutionSuite_Membership_LoginPanel0_LoginButton") 
	WebElement Login;
	@FindBy(xpath="//sup[@title=\"this field is required\"]")
	List<WebElement> MandatoryFields;
	DropDownMethod ddm = new DropDownMethod();
	//Action Methods
	
	public void initialstep()
	{
		AccessManagement.click();
		Master.click();
		SubDepartment.click();
	}
	
	//TS0051 - Create a new Sub Department
	public void VerifySubDepartmentPage() 
	{
		initialstep();
		NewDept.click();
		Assert.assertTrue(NewSubDepartPage.isDisplayed(), "New Sub Department page is not displayed");
	}
	//TS0052 - Fill Sub Department Details
	public void AddSubDepartment(String Department, String Code, String Name, String AuditRemark) throws InterruptedException
	{
		initialstep();
		NewDept.click();
		Dpartdrop.click();
		DepartmentName.sendKeys(Department);
		for(WebElement value : DpartOptions) 
		{
			if(value.getText().trim().equals(Department))
			{
				value.click();
				break;
			}
			
		}
		
		SubDCode.sendKeys(Code);
		SubDName.sendKeys(Name);
		Audit.sendKeys(AuditRemark);
		Save.click();
		Thread.sleep(3000);
		Assert.assertTrue(NewDept.isDisplayed(), "SubDepartment is not added successfully");
	}
	
	//TS0053 - View existing Sub Department Details
	public void ViewSubDept(String SubDName)
	{
		initialstep();
		EditSearchDepart.sendKeys(SubDName);
		for (WebElement subdept : SubDeptList) {
			if (subdept.getText().trim().equals(SubDName)) {
				subdept.click();
				System.out.println("SubDepartment Details:" +SelectedDept.getText()+ ","+ "\n"
				+ViewSubDCode.getAttribute("value")+ ","+"\n" +ViewSubDName.getAttribute("value")+ ","+"\n" 
				+ViewAuditRemark.getAttribute("value"));
				break;
			}
		}		
	}
	//TS0054 - Edit existing Sub Department Details
	public void EditDeparment(String SubDName, String DeptName, String Code, String Name ) throws InterruptedException
	{
		initialstep();
		EditSearchDepart.sendKeys(SubDName);
		Thread.sleep(3000);
		//System.out.println(EditSubDName.getText());
		for (WebElement subdept : SubDeptList) {
			if (subdept.getText().trim().equals(SubDName)) {
				subdept.click();
				EditDeptDrop.click();
				//EditSDeptName.sendKeys(DeptName);
				ddm.selectFromDropdown(EditDeptOptions, "Sales Department", "Department");
				EditCode.clear();
				EditCode.sendKeys(Code);
				EditName.clear();
				EditName.sendKeys(Name);
				EditSaveApply.click();
				EditBackArrow.click();
				break;
			}
		}	
		Assert.assertTrue(NewDept.isDisplayed(), "Sub Department is not updated successfully");
	}
	
	//TS0056 - Export SubDepartment list to Excel
	public void ExportExcel() throws InterruptedException
	{
		initialstep();
		ExcelExport.click();
		Thread.sleep(10000);
	}
	
	//TS0057 - Export SubDepartment list to PDF
	public void ExportPDF() throws InterruptedException {
		initialstep();
		PDFExport.click();
		Thread.sleep(10000);
	}
	
	//TS0058 - Search SubDepartment by Code or Name
	public void VerifySearch(String SubDName, String SubCode)
	{
		initialstep();
		EditSearchDepart.sendKeys(SubDName);
		if(SearchResultName.getText().trim().equals(SubDName))
        {
            System.out.println("Search Successful - SubDepartment found: " +SearchResultName.getText());
        }
        else
        {
            System.out.println("Search Failed - SubDepartment not found");
        }
		
		EditSearchDepart.clear();
		EditSearchDepart.sendKeys(SubCode);
		if (SearchResultCode.getText().trim().equals(SubDName)) {
			System.out.println("Search Successful - SubDepartment found: " + SearchResultName.getText());
		} else {
			System.out.println("Search Failed - SubDepartment not found");
		}
	}
	
	//TS0059 - Check whether sub department added in one company admin should not get reflected in other company admin
	public void VerifySubDeptAcrossCompanies(String SubDName) throws InterruptedException {
	    initialstep();
	    EditSearchDepart.sendKeys(SubDName);

	    try {
	        if (SearchResultName.getText().trim().equals(SubDName)) {
	            System.out.println("SubDepartment found: " + SearchResultName.getText());
	        } else {
	            System.out.println("SubDepartment not found");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("SubDepartment not found (element not present)");
	        // Do nothing — this is expected, so we let the test continue
	    }

	    Profile.click();
	    Logout.click();

	    // Login
	    User.sendKeys("enviro");
	    Pass.sendKeys("Smarti@123");
	    Login.click();

	    initialstep();
	    EditSearchDepart.sendKeys(SubDName);

	    try {
	        if (SearchResultName.getText().trim().equals(SubDName)) {
	            System.out.println("SubDepartment found: " + SearchResultName.getText());
	            Assert.fail("SubDepartment should not be found in the second company, but it was.");
	        } else {
	            System.out.println("SubDepartment not found in second company as expected");
	            Assert.assertTrue(true);
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("SubDepartment not found in second company as expected (element not present)");
	        Assert.assertTrue(true); // ✅ Pass the test because not found is expected
	    }
	}

	//TS0060 - check if mandatory field is not provided then pop up message is displayed or not
	public void MandatoryFieldCheck() throws InterruptedException {
		initialstep();
		NewDept.click();
		Thread.sleep(2000);
		List<String> FieldNames = Arrays.asList("Department", "Name","Code");
		
		int i=0;
		for (WebElement AstrickSign : MandatoryFields) {
		    if (AstrickSign.isDisplayed()) {
		        System.out.println("Mandatory sign is displayed for: " + FieldNames.get(i));
		    } else {
		        System.out.println("Mandatory sign is NOT displayed for: " + FieldNames.get(i));
		    }
		    i++;
		}
	}

}
