package LoginTest;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest
{
	WebDriver driver;
	LoginPage lp;
	
	@BeforeTest
	public void openbrowser()
	{
		driver=new ChromeDriver();
		driver.get("http://localhost:170/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		lp = new LoginPage(driver);
	}
	
	@Test
	public void Login()
	{
		lp.loginCredentials("Crisil", "Smarti@123");
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
