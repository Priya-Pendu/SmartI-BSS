package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage 
{
	
	
	
	WebDriver driver;
	
	//Constructor
	public LoginPage (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Locators
	
	@FindBy(xpath = "//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement Username;
	@FindBy(xpath ="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Password;
	@FindBy(xpath = "//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement LoginButton;

	
	//ActionMethods
	/*
	public void setUserName (String user)
	{
		Username.sendKeys(user);
	}
	
	public void setPassword (String password)
	{
		Password.sendKeys(password);
	}
	
	public void clickLogin ()
	{
		LoginButton.click();
	}
	*/
}
