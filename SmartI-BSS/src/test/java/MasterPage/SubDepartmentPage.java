package MasterPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import LoginTest.LoginPage;
import PageObject.BasePage;

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
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog16_SubDepartmentCode']")
	WebElement EditCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_SubDepartmentDialog16_SubDepartmentName']")
	WebElement EditName;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement EditSaveApply;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement EditBackArrow;
	//
	//Action Methods
	
	public void AddSubDepartment(String Department, String Code, String Name, String AuditRemark)
	{
		AccessManagement.click();
		Master.click();
		SubDepartment.click();
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
		System.out.println(Alert.getText());
		ok.click();
		BackArrow.click();
		
		
	}
	
	public void EditDeparment(String SubDName, String DeptName, String Code, String Name ) throws InterruptedException
	{
		EditSearchDepart.sendKeys(SubDName);
		
		Thread.sleep(3000);
		
		System.out.println(EditSubDName.getText());
		if(EditSubDName.getText().equals(SubDName))
		{
			EditSubDName.click();
		}
		else
		{
			System.out.println("SubDepartment name dose not match");
		}
		
		
		EditDeptDrop.click();
		EditSDeptName.sendKeys(DeptName);
		
		for (WebElement SelectDept : EditDeptOptions)
		{
			if(SelectDept.getText().trim().equals(DeptName))
			{
				SelectDept.click();
				break;
			}
		}
		
		EditCode.clear();
		EditCode.sendKeys(Code);
		EditName.clear();
		EditName.sendKeys(Name);
		EditSaveApply.click();
		EditBackArrow.click();
	}
}
