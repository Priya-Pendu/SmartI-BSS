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
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SP = new StatePage(driver);
	}
	
	@Test(priority=1)
	void State() throws InterruptedException
	{
		LoginPage LP = new LoginPage(driver);
		LP.LginCredentials("Crisil", "Smarti@123");
		SP.AddState("ABC", "India");
	}
	
	@Test(priority=2)
	void updateState() throws InterruptedException
	{
		SP.EditState("ABC", "PQR", "Indonesia");
	}
	
	@AfterTest
	void Logout()
	{
		if (driver != null) {
            driver.quit();
        }
	}

}
