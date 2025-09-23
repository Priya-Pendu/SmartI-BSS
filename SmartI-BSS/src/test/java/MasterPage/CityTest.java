package MasterPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;

public class CityTest 
{
	WebDriver driver;
	CityPage cp;
	
	@BeforeTest
	public void login()
	{
		driver= new ChromeDriver();
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cp = new CityPage(driver);
	}
	
	@Test(priority=1)
	public void AddNewCity() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("Crisil", "Smarti@123");
		cp.AddCity("Bhiwandi", "India", "Maharashtra");
	}
	
	@Test(priority=2)
	public void UpdateCity()
	{
		cp.EditState("Bhiwandi", "Bhiwandi1");
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	

}
