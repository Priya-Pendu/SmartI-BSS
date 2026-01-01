package LoginTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	LoginPage lp;
	
	@BeforeTest
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:915/");
		driver.manage().window().maximize();
		 lp = new LoginPage(driver);
	}
		
	@Test(priority=1, groups="master")
	void testLogin()
	{
		lp.LginCredentials("admin","admin");
	}
	
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
}
