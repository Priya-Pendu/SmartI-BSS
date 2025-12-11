package MasterPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;

public class UserPageObject extends BasePage
{
	//constructors
	public UserPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]")
	WebElement AccessManagement;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[11]/a[1]")
	WebElement Administration;
	@FindBy(xpath="//span[normalize-space()='User']")
	WebElement User;
	@FindBy(xpath="//span[normalize-space()='New User']")
	WebElement NewUser;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Administration-UserDialog s-Administration-UserDialog s-UserDialog ui-draggable ui-resizable flex-layout']")
	WebElement NewUserWindow;
	@FindBy(xpath="//input[@name=\"Username\"]")
	WebElement UName;
	@FindBy(xpath="//input[@name='DisplayName']")
	WebElement DName;
	@FindBy(xpath="//input[@name='Email']")
	WebElement Email;
	@FindBy(xpath="//input[@class='emaildomain']")
	WebElement EmailDomain;
	@FindBy(xpath="//input[@name='Password']")
	WebElement Passw;
	@FindBy(xpath="//input[@name='PasswordConfirm']")
	WebElement ConfirmPassW;
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Save;
	@FindBy(xpath="//a[normalize-space()='Misc']")
	WebElement Misc;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable ui-resizable']")
	WebElement Alert; 
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable ui-resizable']//button[@title='Close']")
	WebElement CloseAlertWindow;
	@FindBy (xpath="//button[@title='Close']")
	WebElement CloseNewUWindow;
	
	
	//Edit User Locators 
	
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement EditSearch;
	@FindBy(xpath="//div[@class='slick-cell l1 r1']/a")
	WebElement EditSelectUser;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Administration-UserDialog s-Administration-UserDialog s-UserDialog ui-draggable ui-resizable flex-layout']")
	WebElement EditUserWindow;
	@FindBy(name="Username")
	WebElement EditUserName;
	@FindBy(name="DisplayName")
	WebElement EditDisplayN;
	@FindBy(xpath="//a[normalize-space()='Misc']")
	WebElement EditMisc;
	@FindBy(name="PasswordExpiryInDays")
	WebElement EditPassExpiryDate;
	@FindBy (xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement EditSaveApply ;
	@FindBy(xpath="//button[@title='Close']")
	WebElement CloseWindow;
	
	
	//action mehtods
	public void AddUser(String UserName, String DisplayName,String NEmail, String Password) throws InterruptedException
	{
		AccessManagement.click();
		Thread.sleep(3000);		
		Administration.click();
		User.click();
		NewUser.click();
		if(NewUserWindow.isDisplayed())
		{
			System.out.println("New User Window Displayed");
			//System.out.println(NewUserWindow.getText());
		}
		else 
		{
			System.out.println("New User window did not display");
		}
		
	
		UName.sendKeys(UserName);
		DName.sendKeys(DisplayName);
		Thread.sleep(3000);
		Email.clear();
		Email.sendKeys(NEmail);
		EmailDomain.clear();
		EmailDomain.sendKeys("gmail.com");
		Passw.clear();
		Passw.sendKeys(Password);
		ConfirmPassW.clear();
		ConfirmPassW.sendKeys(Password);
		Save.click();
		Thread.sleep(3000);
		System.out.println(Alert.getText());
		CloseAlertWindow.click();
		CloseNewUWindow.click();
		
	
		//input[@name="Username"]
	}
	
	public void EditUser(String User, String NewUserN, String NewDisplayN, String PassExpiry) throws InterruptedException
	{
		EditSearch.sendKeys(User);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(EditSelectUser, User));

		if (EditSelectUser.isDisplayed() && EditSelectUser.getText().equals(User))
	
		{
			EditSelectUser.click();
			Thread.sleep(3000);
			System.out.println("UserName get match");
		}
		else
		{
			System.out.println("User name dose not match");
		}
			
		//System.out.println(EditUserWindow.getText());
		
		Thread.sleep(3000);
		EditUserName.clear();
		EditUserName.sendKeys(NewUserN);
		EditDisplayN.sendKeys(NewDisplayN);
		EditMisc.click();
		EditPassExpiryDate.clear();
		EditPassExpiryDate.sendKeys(PassExpiry);
		EditSaveApply.click();
		CloseWindow.click();
		
	}
	
	
}
