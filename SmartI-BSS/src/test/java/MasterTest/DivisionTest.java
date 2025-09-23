package MasterTest;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.DivisionPage;

public class DivisionTest 
{
		WebDriver driver;
		DivisionPage DP;
		
		@BeforeTest
		public void Login()
		{
			driver = new ChromeDriver();
			driver.get("http://localhost:170/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			DP = new DivisionPage(driver);
			
		}
		
		@Test (priority=1)
		public void Division() throws InterruptedException
		{
			
			LoginPage lp = new LoginPage(driver);
		    lp.LginCredentials("Crisil", "Smarti@123");
		    DP.AddDivision("Kalyan", "New-Divi01", "R&D", "Testing Purpose");
		    
			
		}
		
		@Test(priority=2)
		public void updateDivision() throws InterruptedException
		{
			DP.updateDivision("Software-01", "London", "New-Divi02", "Software-01");
		}
		
		@AfterTest
		public void Logout()
		{
			driver.quit();
		}
}
