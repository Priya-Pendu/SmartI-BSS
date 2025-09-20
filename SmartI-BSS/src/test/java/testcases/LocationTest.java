package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import PageObject.LocationPage;

public class LocationTest {

	
WebDriver driver;
LocationPage locp;

	@BeforeTest
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		
	}

	
	@Test (priority = 1)
	void AddLocation() throws InterruptedException
	{
		locp = new LocationPage(driver);
		
		LoginPage lp = new LoginPage(driver);
	    lp.loginCredentials("Crisil", "Smarti@123");
	    locp.click_Location_btn("Jallgaon", "JL1");
		
		
	}
	
	@Test(priority= 2)
	public void UpdateLocation() throws InterruptedException
	{
		locp.EditLocation("Kalyan", "Kalyan", "BWD01", "Test");
	}
	
	@Test (priority = 3 )
	void DeleteLocation() throws InterruptedException
	{
		locp.DeleteLocation("Kalyan");
	}
	
	
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
}
