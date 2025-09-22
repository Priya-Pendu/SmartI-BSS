package MasterTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import LoginTest.LoginTest;
import MasterPage.RolePageObject;

public class RoleTest 
{
	WebDriver driver;
	RolePageObject RP;
	
	@BeforeTest
	public void login()
	{
		driver= new ChromeDriver();
		driver.get("http://localhost:5231/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RP = new RolePageObject(driver);
	}

	
	@Test(priority =1)
	public void NewRole() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginCredentials("Smarti", "Smarti@123");
		RP.AddRole("Recipients");
	}
	
	@Test(priority=2)
	public void UpdateRole() throws InterruptedException
	{
		RP.EditRole("Recipients", "Recipients2");
	}
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
