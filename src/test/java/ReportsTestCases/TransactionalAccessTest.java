package ReportsTestCases;

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
import ReportsPageObject.CardPoolReportPage;
import ReportsPageObject.TransactionalAccessPage;

public class TransactionalAccessTest {

	WebDriver driver;
	TransactionalAccessPage TAP;
	
	@BeforeTest(groups="master")
	public void Login()
	{
		 Map<String, Object> prefs = new HashMap<>();
	     prefs.put("download.default_directory", "D:\\Priya\\BSS_Automation_Files\\Eclipse-Workspace\\SmartISystems-BSS\\SmartI-BSS\\SmartI-BSS\\download");
	     prefs.put("download.prompt_for_download", false);
	     prefs.put("download.directory_upgrade", true);
	     prefs.put("plugins.always_open_pdf_externally", true); // auto-download PDFs

	     ChromeOptions options = new ChromeOptions();
	     options.setExperimentalOption("prefs", prefs);
	        
		driver= new ChromeDriver(options);
		driver.get("http://192.168.0.42:915");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TAP = new TransactionalAccessPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	   //@Test(priority=1, groups="master")
	   public void TS0147() throws InterruptedException {
		   
		   TAP.LocationFilter("Mumbai");
	    }
	
	   
	   //@Test(priority=2, groups="master")
		public void TS0148() throws InterruptedException {

			TAP.DepartmentFilter("Software Department");
		}
	   
		//@Test(priority=3, groups="master")
		public void TS0149() throws InterruptedException {
			TAP.EmployeeFilter("Shreya Sharma");
		}
		
		//@Test(priority=4, groups="master")
		public void TS0150() throws InterruptedException {
			TAP.DeviceLocationFilter("Mumbai");
		}
		
		//@Test(priority=5, groups="master")
		public void TS0151() throws InterruptedException {
			TAP.DeviceFilter("BioSlim12");
		}
		
		@Test(priority=6, groups="master")
		public void TS0152() throws InterruptedException {
			TAP.ReaderFilter("BioSlim Reader 1");
		}
		
	  @AfterTest (groups="master")
	  public void teardown()
	  {
		driver.quit();
	  }
}
