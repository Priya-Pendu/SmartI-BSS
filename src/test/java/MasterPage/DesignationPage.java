package MasterPage;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.BasePage;



public class DesignationPage extends BasePage
{
	//Construtor
	public DesignationPage(WebDriver driver) 
	{
		super(driver);
	
	}

	//Locators
	@FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]") WebElement AccessManagement;
	@FindBy(xpath="//i[@class='nav-icon fa fa-th-list']") WebElement Master;
	@FindBy(xpath="//a[@href='/Master/Designation']//span[contains(text(),'Designation')]") WebElement Designation;
	@FindBy(xpath="//span[normalize-space()='New Designation']") WebElement NewD;
	@FindBy(id="BuildingSolutionSuite_Master_DesignationDialog10_DesignationCode") WebElement DesigCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DesignationDialog10_DesignationName']") WebElement DesigName;
	@FindBy(xpath="//textarea[@id='BuildingSolutionSuite_Master_DesignationDialog10_AuditRemark']") WebElement AuditRM;
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement Savebtn;
	@FindBy(xpath="//button[@class='panel-titlebar-close']") WebElement BackArrow;
	//Edit Designation locators
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement EditSDesignation;
	@FindBy(xpath="//div[@class='slick-cell l1 r1']/a")
	WebElement EditDesignation;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DesignationDialog10_DesignationCode']")
	WebElement EditDesigCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DesignationDialog10_DesignationName']")
	WebElement EditDesigName;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement EditSaveApply;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']") WebElement ok;
	@FindBy(xpath="//div[@class='panel-titlebar']")
	WebElement NewDesignationTitle;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']")
	WebElement ExporttoExcel;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']")
	WebElement ExporttoPDF;
	@FindBy(xpath="//div[@class='slick-cell l1 r1']")
	WebElement DesigNResult;
	@FindBy(xpath="//div[@class='slick-cell l0 r0']")
	WebElement DesigCResult;
	
	//Action Methods
	public void initialstep()
	{
		AccessManagement.click();
		Master.click();
		Designation.click();
	}
	
	//TS0062 - Create a new Designation
	public void VerifyDesignationPage() {
		initialstep();
		NewD.click();
		Assert.assertTrue(NewDesignationTitle.isDisplayed(), "New Designation page is not displayed");
	}
	
	//TS0063 - Fill Designation Details
	public void AddDesignation(String DesignationCode, String DesignationName,String AuditRemark) throws InterruptedException

	{	initialstep();
		NewD.click();
		DesigCode.sendKeys(DesignationCode);
		DesigName.sendKeys(DesignationName);
		AuditRM.sendKeys(AuditRemark);
		Savebtn.click();
		Thread.sleep(2000);
		Assert.assertTrue(NewD.isDisplayed(), "Designation not added");
	}
	
	//TS0064 - View an existing Designation
	public void ViewDesignation(String Desig) throws InterruptedException 
	{
		initialstep();
		EditSDesignation.sendKeys(Desig);
		Thread.sleep(3000);

		if (EditDesignation.getText().equals(Desig)) {
			EditDesignation.click();
			System.out.println("Designation Details: " + EditDesigCode.getAttribute("value") + ", " + EditDesigName.getAttribute("value"));	
			BackArrow.click();
		} 
		Assert.assertTrue(NewD.isDisplayed(), "Unable to view Designation details");
	}
	
	//TS0065 - Edit an existing Designation
	public void EditDesignation(String Desig, String NewDesigC, String NewDesigN) throws InterruptedException
	{
		initialstep();
		EditSDesignation.sendKeys(Desig);
		Thread.sleep(3000);
		
		if(EditDesignation.getText().equals(Desig))
		{
			EditDesignation.click();
		}
		else
		{
			System.out.println("Designation does not match");
		}
		
		EditDesigCode.clear();
		EditDesigCode.sendKeys(NewDesigC);
		EditDesigName.clear();
		EditDesigName.sendKeys(NewDesigN);
		EditSaveApply.click();
		BackArrow.click();
		Assert.assertTrue(NewD.isDisplayed(), "Alert popup is not displayed");
		
	}

	//TS0067 - Export Designation list to Excel
	public void VerifyExcelbtn() throws InterruptedException {
		initialstep();
		ExporttoExcel.click();
		Thread.sleep(10000);
	}
	
	//TS0068 - Export Designation list to PDF
	public void VerifyPDFbtn() throws InterruptedException {
		initialstep();
		ExporttoPDF.click();
		Thread.sleep(10000);
	}
	
	//TS0069 - Search Designation by Code or Name
	public void VerifySearch(String DesigName, String DesigCode) throws InterruptedException
	{
		initialstep();
		EditSDesignation.sendKeys(DesigName);
		Thread.sleep(2000);
		Assert.assertEquals(DesigNResult.getText().trim(), DesigName, "Designation does not match");
		Thread.sleep(2000);
		EditSDesignation.clear();
		EditSDesignation.sendKeys(DesigCode);
		Thread.sleep(2000);
		Assert.assertEquals(DesigCResult.getText().trim(), DesigCode, "Designation does not match");
	}
}
