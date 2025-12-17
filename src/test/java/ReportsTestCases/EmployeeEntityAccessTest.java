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
import ReportsPageObject.EmployeeActiveStatusPage;
import ReportsPageObject.EmployeeEntityAccessPage;

public class EmployeeEntityAccessTest {

	WebDriver driver;
	EmployeeEntityAccessPage EEAP;
	
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
	        
		driver= new ChromeDriver(options);
		driver.get("http://192.168.0.42:915");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		EEAP = new EmployeeEntityAccessPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		}
	
	    //@Test(priority=1)
		public void TS0136() throws InterruptedException
		{
			EEAP.ExportToExcel();
		}
		
	    //@Test(priority=2)
	    public void TS0137() throws InterruptedException
	    {
	    	EEAP.GeneratePDFReport();
	    }
	    
	   //@Test(priority=3)
	   public void TS0138() throws InterruptedException {
		EEAP.LocationFilterValidation();
	   }
	
	   //@Test(priority=4)
	   public void TS0139() throws InterruptedException {
		   EEAP.DepartmentFilterValidation();
	   }
	   
	    //@Test(priority=5)
		public void TS0140() throws InterruptedException {
			EEAP.DesignationFilterValidation();
		}
	   
	    //@Test(priority=6)
	   	public void TS0141() throws InterruptedException {
	   		EEAP.EntityFilterValidation();
	   	}
	   	
	    @Test(priority=7)
		public void TS0142() throws InterruptedException {
			EEAP.EmployeeFilterValidation();
		 }
		
	   @AfterTest
	    public void TearDown()
	    {
		  driver.quit();
	    }
}
