package ReportsTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import LoginTest.LoginTest;
import ReportsPageObject.MasterReports;

public class MasterReportsTest 
{
	WebDriver driver;
	MasterReports MR;
	
	
	@BeforeTest
	public void Login()
	{
		driver= new ChromeDriver();
		driver.get("http://192.168.0.4:5292/Account/Login?ReturnUrl=%2f");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		MR = new MasterReports(driver);
		
	}
	
	
	@Test
	public void ReportOrganization() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("One96", "Smarti@123");
		MR.MasterOrgReport("Access");
		
		
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
