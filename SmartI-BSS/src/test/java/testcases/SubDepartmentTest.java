package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import PageObject.SubDepartmentPage;

public class SubDepartmentTest
{
	WebDriver driver;
	SubDepartmentPage SD;
	
	@BeforeTest
	public void login()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:170/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		SD = new SubDepartmentPage(driver);
	}
	
	@Test (priority=1)
	public void SubDepartment()
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginCredentials("Crisil", "Smarti@123");
		SD.AddSubDepartment("Account Department", "SubD-01", "Salaries & Tax", "Remark");
	}
	
	@Test(priority=2)
	public void UpdateDepartment() throws InterruptedException
	{
		SD.EditDeparment("ACS KIAM", "Account Department", "150", "ACS KIAM");
	}
	
	
	@AfterTest
	public void Logout()
	{
		driver.quit();
	}
}
