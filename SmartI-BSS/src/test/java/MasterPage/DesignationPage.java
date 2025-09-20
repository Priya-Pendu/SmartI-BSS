package MasterPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObject.BasePage;

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
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DesignationDialog17_DesignationCode']")
	WebElement EditDesigCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DesignationDialog17_DesignationName']")
	WebElement EditDesigName;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement EditSaveApply;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']") WebElement ok;
	
	//Action Methods
	public void AddDesignation(String DesignationCode, String DesignationName,String AuditRemark) throws InterruptedException
	{
		AccessManagement.click();
		Master.click();
		Designation.click();
		NewD.click();
		DesigCode.sendKeys(DesignationCode);
		DesigName.sendKeys(DesignationName);
		Thread.sleep(3000);
		AuditRM.sendKeys(AuditRemark);
		Thread.sleep(3000);
		Savebtn.click();
		System.out.println(Alert.getText());
		ok.click();
		BackArrow.click();
	}
	
	public void EditDesignation(String Desig, String NewDesigC, String NewDesigN) throws InterruptedException
	{
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
		
	}
}
