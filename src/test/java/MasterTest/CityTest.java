package MasterTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.CityPage;

public class CityTest 
{
	WebDriver driver;
	CityPage cp;
	
	@BeforeTest
	public void login()
	{
		driver= new ChromeDriver();
		driver.get("http://localhost:915/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cp = new CityPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
	}
	
	@Test(priority=1, groups="master")
	public void TS0081()
	{
		cp.VerifyCityPg();
	}
	
	@Test(priority=2, groups="master")
	public void TS0082() throws InterruptedException
	{
		
		cp.AddCity("Bhiwandi", "India", "Maharashtra");
	}
	
	@Test(priority=3, groups="master")
	public void TS0083()
	{
		cp.ViewCity("Bhiwandi");
	}
	
	@Test(priority=4, groups="master")
	public void TS0084() throws InterruptedException
	{
		cp.EditState("Bhiwandi", "Bhiwandi2");
	}
	
	@Test(priority=5, groups="master")
	public void TS0086()
	{
		cp.VerifySearch("Bhiwandi2");
	}
	
	@Test(priority=6, groups="master")
	public void TS0087() throws InterruptedException
    {
		cp.VerifyAccrossCompanies("Mumbai");
    }
	
	@Test(priority=7, groups="master")
	public void TS0088() throws InterruptedException
	{
		cp.verifyCountryFilter("India");
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	

}
