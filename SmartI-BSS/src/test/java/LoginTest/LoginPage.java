package LoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePage;


public class LoginPage extends BasePage
{
	WebDriver driver;
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators	
	@FindBy(xpath = "//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement Username;
	@FindBy(xpath ="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Password;
	@FindBy(xpath = "//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement LoginButton;

	
	//ActionMethods
	public void LginCredentials (String user,String pass)
	{
	    Username.sendKeys(user);
	    Password.sendKeys(pass);
	    LoginButton.click();
	}
	
}
