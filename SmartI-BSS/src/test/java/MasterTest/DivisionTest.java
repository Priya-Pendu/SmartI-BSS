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
			driver.get("http://localhost:915/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			DP = new DivisionPage(driver);
			LoginPage lp = new LoginPage(driver);
		    lp.LginCredentials("tata", "Smarti@123");
		}
		
		//@Test(priority=1)
		public void TS0030() throws InterruptedException
		{
			DP.VerifyNewDivisionPage();
			
		}
		
		//@Test (priority=2)
		public void TS0031() throws InterruptedException
		{
		    DP.AddDivision("Kalyan", "New-Divi05", "R&D05", "Testing Purpose"); 
		}
		
		
		//@Test(priority=3)
		public void TS0032() throws InterruptedException
		{
			DP.ViewExistDivi("Marketing");
		}
		
		@Test(priority=4)
		public void TS0033() throws InterruptedException
		{
			DP.EditDivision("Software-01", "London", "New-Divi02", "Software-01");
		}
		
		@AfterTest
		public void Logout()
		{
			driver.quit();
		}
}
