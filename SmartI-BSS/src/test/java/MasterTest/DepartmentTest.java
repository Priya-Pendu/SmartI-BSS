package MasterTest;

import java.time.Duration;


import LoginTest.LoginPage;
import MasterPage.DepartmentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepartmentTest 
{
	WebDriver driver;
	DepartmentPage Dp;

	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Dp = new DepartmentPage(driver);
	}

	@Test(priority=1)
	public void AddDepartment() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
	    lp.LginCredentials("Crisil", "Smarti@123");
		Dp.AddDepartment("Pune", "ACS", "Ac-01", "Account Department", "Test");
	}
	
	@Test(priority=2)
	public void UpdateDepartment() throws InterruptedException
	{
		Dp.EditDepartment("Account Department", "London", "Software-01", "New Code", "Software Department");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
