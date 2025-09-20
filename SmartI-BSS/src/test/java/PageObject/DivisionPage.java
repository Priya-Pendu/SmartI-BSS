package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DivisionPage extends BasePage

{
	WebDriver driver;
	
	public DivisionPage(WebDriver driver) {
		super(driver);
	}
	
	//AddLocation Locators
	@FindBy (xpath="//div[contains(@class,'row')]//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]")
	WebElement AccessManagement;
	@FindBy(xpath="//b[@role='presentation']") 
	WebElement LocationDrop ;
	@FindBy(xpath="//ul[@id='select2-results-1']/*") 
	List <WebElement> LocationOptions;
	@FindBy(name="DivisionCode") 
	WebElement CodeText;
	@FindBy(name ="DivisionName") 
	WebElement Name;
	@FindBy(id ="BuildingSolutionSuite_Master_DivisionDialog8_AuditRemark") 
	WebElement Remark;
	@FindBy (xpath = "//span[normalize-space()='Save']") 
	WebElement savebutton;
	@FindBy(id = "BuildingSolutionSuite_Membership_LoginPanel0_Username") 
	WebElement User;
	@FindBy(id="BuildingSolutionSuite_Membership_LoginPanel0_Password") 
	WebElement Pass;
	@FindBy(id ="BuildingSolutionSuite_Membership_LoginPanel0_LoginButton") 
	WebElement Login;
	@FindBy(xpath ="//p[contains(@class,'title-text')][contains(text(),'Access')]") 
	WebElement AccessModule;
	@FindBy(xpath = "//i[@class='nav-icon fa fa-th-list']") 
	WebElement MasterDropBtn;
	@FindBy(xpath ="//a[@href='/Master/Division']//span[contains(text(),'Division')]") 
	WebElement Divisionbtn;
	@FindBy(xpath ="//span[normalize-space()='New Division']") 
	WebElement NewDivision;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement Yes;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrow;

	//UpdateDivision locators
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement EditSearchDivi;
	@FindBy(xpath="//div[@class='slick-cell l2 r2']/a")
	WebElement Division;
	@FindBy(xpath="//b[@role='presentation']")
	WebElement EditLocationDrop;
	@FindBy(xpath="//input[@id='s2id_autogen13_search']")
	WebElement EditSearchLocation;
	@FindBy (xpath="//ul[@class='select2-results']/*")
	List <WebElement> EditLocationOptions;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DivisionDialog16_DivisionCode']")
	WebElement EditCode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DivisionDialog16_DivisionName']")
	WebElement EditName;
	@FindBy(xpath="//div[@title='Apply Changes']//div[@class='button-outer']")
	WebElement Applychange;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrowbtn;
	
	
	//ActionMethods
	
	public void AddDivision(String Location, String Code, String DivisionName, String AuditRemark) throws InterruptedException
	{
		//open the division page
		AccessManagement.click();
		MasterDropBtn.click();
		Divisionbtn.click();
		NewDivision.click();
		
		//select the location
		LocationDrop.click();
		Thread.sleep(3000);
		
		for(WebElement value : LocationOptions)
		{
			if(value.getText().trim() .equals(Location))
			{
				value.click();
				break;
			}
		}
		
		//fill the other fields
		
		CodeText.sendKeys(Code);
		Name.sendKeys(DivisionName);
		Remark.sendKeys(AuditRemark);
		
		//save the details
		savebutton.click();
		
		//if not save to handle warning
		System.out.println(Alert.getText());
		Yes.click();
		BackArrow.click();
		
	}
	
	
	public void updateDivision(String Divi,String NewLocation, String NewCode, String NewName ) throws InterruptedException
	{
		EditSearchDivi.sendKeys(Divi);
		Thread.sleep(3000);
		
		if(Division.getText().equals(Divi))
		{
			Division.click();
			
		}
		else
		{
			System.out.println("Division is not available");
		}
		
		//change the location
		EditLocationDrop.click();
		EditSearchLocation.sendKeys(NewLocation);
		
		for(WebElement value : EditLocationOptions)
		{
			if(value.getText().trim() .equals(NewLocation))
			{
				value.click();
				break;
			}
		}
		
		EditCode.clear();
		EditCode.sendKeys(NewCode);
		
		EditName.clear();
		EditName.sendKeys(NewName);
		Applychange.click();
		BackArrowbtn.click();
	}
}
