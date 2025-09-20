package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.DesignationPage;

public class DesginationTest 
{
	WebDriver driver;
	DesignationPage DP;
	
	@BeforeTest
	void login()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DP = new DesignationPage(driver);
	}
	
	@Test(priority=1)
	void Designation() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginCredentials("Crisil", "Smarti@123");
		
		DP.AddDesignation("Soft-01", "Software Developer", "Add");
		
	}
	
	@Test(priority=2)
	public void updateDesignation() throws InterruptedException
	{
		DP.EditDesignation("ACS Team", "0002", "ACS Team");
	}
	
	@AfterTest
	void logut()
	{
		driver.quit();
	}
}
