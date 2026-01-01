package MasterTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.DashboardPage;

public class DashboardTest 
{
	WebDriver driver;
	DashboardPage DP;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:5231/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DP = new DashboardPage(driver);
	}

	@Test(priority = 1, groups="master")
	public void InActiveEmpCheck()
	{
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("Smarti", "Smarti@123");
		DP.InActiveEmp();
	}
	
	@Test(priority=2, groups="master")
	public void CriticalEventCheck()
	{
		DP.CriticalEvent();
	}
	
	@Test (priority=3, groups="master")
	public void EmoloyeeInCheck()
	{
		DP.EmployeeIN();
	}
	
	@Test(priority=4, groups="master")
	public void Tailgatingcount()
	{
		DP.CriticalEvent();
	}
	
	@Test(priority =5, groups="master")
	public void UserHourlyAccess()
	{
		DP.UHAccess();
	}
	
	@Test(priority = 6, groups="master")
	public void Top5MostAccessDevices()
	{
		DP.Top5MAD();
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}	
}
