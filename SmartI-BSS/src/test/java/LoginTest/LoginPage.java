


package LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class LoginPage extends BasePage
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement User;
	@FindBy(xpath ="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Pass;
	@FindBy(xpath ="//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement Loginbtn;
	
	public void loginCredentials(String Username, String Password)
	{
		User.sendKeys(Username);
		Pass.sendKeys(Password);
		Loginbtn.click();
	}

}
