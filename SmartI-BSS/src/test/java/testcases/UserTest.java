package testcases;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import PageObject.UserPageObject;


public class UserTest 
{
	WebDriver driver;
	UserPageObject UP;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:5231/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		UP = new UserPageObject(driver);
	}
	
	@Test(priority=1)
	public void AddUser() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginCredentials("Smarti", "Smarti@123");
		UP.AddUser("Test", "Priya", "priyapendu", "Priya@12345");
	}
	
	@Test(priority=2)
	public void UpdateUser() throws InterruptedException
	{
		UP.EditUser("Test", "Test1", "Test1", "50");
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	

}
