package MasterTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.StatePage;

public class StateTest
{
	WebDriver driver;
	StatePage SP;
	
	@BeforeTest
	void Login()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:915/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SP = new StatePage(driver);
		LoginPage LP = new LoginPage(driver);
		LP.LginCredentials("tata", "Smarti@123");
	}
	
	//@Test(priority=1)
	public void TS0073() throws InterruptedException
	{
		SP.VerifyNewStatePage();
	}
	
	//@Test(priority=2)
	void TS0074() throws InterruptedException
	{
		SP.AddState("TEst123", "India");
	}
	
	//@Test(priority=3)
	public void TS0075() throws InterruptedException {
		SP.ViewState("TEst123");
	}
	
	//@Test(priority=4)
	void TS0076() throws InterruptedException
	{
		SP.EditState("ABC", "TEst321");
	}
	
	//@Test(priority=5)
	public void TS0077() throws InterruptedException {
		SP.VerifySearch("TEst321");
	}
	
	@Test(priority=6)
	public void TS0078() throws InterruptedException
	{
		SP.CheckStateAccrosCompanies("Test");
	}
	
	@AfterTest
	void Logout()
	{
		if (driver != null) {
            driver.quit();
        }
	}

}
