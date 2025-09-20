package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class LoginTest {

	WebDriver driver;
	
	@BeforeTest
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
	}
	
	
	@Test
	/*void testLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("Crisil");
		lp.setPassword("Smarti@123");
		lp.clickLogin();
		
	}
	*/
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
}
