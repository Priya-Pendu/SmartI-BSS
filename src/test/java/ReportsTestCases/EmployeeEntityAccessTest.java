package ReportsTestCases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import ReportsPageObject.EmployeeActiveStatusPage;
import ReportsPageObject.EmployeeEntityAccessPage;

public class EmployeeEntityAccessTest {

	WebDriver driver;
	EmployeeEntityAccessPage EEAP;
	
	@BeforeMethod
	public void Login()
	{
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", "D:\\Priya\\BSS_Automation_Files\\Eclipse-Workspace\\SmartISystems-BSS\\SmartI-BSS\\SmartI-BSS\\download");
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("plugins.always_open_pdf_externally", true); // auto-download PDFs

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--headless"); // headless mode
		options.addArguments("--window-size=1920,1080"); // necessary in headless
		options.addArguments("--disable-gpu"); // sometimes needed on Windows

		driver = new ChromeDriver(options);

		driver.get("http://192.168.0.42:915");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		EEAP = new EmployeeEntityAccessPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"regression , functional "})
		public void TS0136() throws InterruptedException
		{
			EEAP.ExportToExcel();
		}
		
	    @Test(groups={"regression, functional"})
	    public void TS0137() throws InterruptedException
	    {
	    	EEAP.GeneratePDFReport();
	    }
	    
	   @Test(groups={"regression, functional"})
	   public void TS0138() throws InterruptedException {
		EEAP.LocationFilterValidation();
	   }
	
	   @Test(groups={"regression, functional"})
	   public void TS0139() throws InterruptedException {
		   EEAP.DepartmentFilterValidation();
	   }
	   
	    @Test(groups={"regression, functional"})
		public void TS0140() throws InterruptedException {
			EEAP.DesignationFilterValidation();
		}
	   
	    @Test(groups={"regression, functional"})
	   	public void TS0141() throws InterruptedException {
	   		EEAP.EntityFilterValidation();
	   	}
	   	
	    @Test(groups={"regression, functional"})
		public void TS0142() throws InterruptedException {
			EEAP.EmployeeFilterValidation();
		 }
		
	   @AfterMethod
	    public void TearDown()
	    {
		  driver.quit();
	    }
}
