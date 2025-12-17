package MasterTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		    Map<String, Object> prefs = new HashMap<>();
	        prefs.put("download.default_directory", "D:\\Priya\\BSS_Automation_Files\\Eclipse-Workspace\\SmartISystems-BSS\\SmartI-BSS\\SmartI-BSS\\download");
	        prefs.put("download.prompt_for_download", false);
	        prefs.put("download.directory_upgrade", true);
	        prefs.put("plugins.always_open_pdf_externally", true); // auto-download PDFs

	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs); 
		        
			driver = new ChromeDriver(options);
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
		
		//@Test(priority=4)
		public void TS0033() throws InterruptedException
		{
			DP.EditDivision("Software-01", "Mumbai	", "New-Divi02", "Software-01");
		}
		
		//@Test(priority=5)
		public void TS0034() throws InterruptedException
		{
			DP.ExportExcel();
		}
		
		//@Test(priority=6)
		public void TS0035() throws InterruptedException
		{
			DP.ExportPDF();
		}
		
		@Test(priority=7)
		public void TS0036() throws InterruptedException
		{
			DP.VerifySearchBar("Division C", "Divi-B");
		}
		
		@AfterTest
		public void Logout()
		{
			driver.quit();
		}
}
