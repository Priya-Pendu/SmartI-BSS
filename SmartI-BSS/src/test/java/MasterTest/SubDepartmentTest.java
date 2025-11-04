package MasterTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.SubDepartmentPage;

public class SubDepartmentTest
{
	WebDriver driver;
	SubDepartmentPage SD;
	
	@BeforeTest
	public void login()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:915/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		SD = new SubDepartmentPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@123");
	}
	
	//@Test(priority=1)
	public void TS0051()
	{
		SD.VerifySubDepartmentPage();
	}
	
	//@Test (priority=2)
	public void SubDepartment() throws InterruptedException
	{
		
		SD.AddSubDepartment("Sales Department", "SubD-10", "Pre-Sales", "Remark");
	}
	
	//@Test(priority=3)
	public void TS0053() throws InterruptedException {
		SD.ViewSubDept("Pre-Sales");
	}
	
    @Test(priority=4)
	public void UpdateDepartment() throws InterruptedException
	{
		SD.EditDeparment("ACS KIAM", "Sales Department", "200", "ACS KIAM");
	}
	
	
	@AfterTest
	public void Logout()
	{
		driver.quit();
	}
}
