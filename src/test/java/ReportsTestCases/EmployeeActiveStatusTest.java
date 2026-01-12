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
import ReportsPageObject.DesignationReportPage;
import ReportsPageObject.EmployeeActiveStatusPage;

public class EmployeeActiveStatusTest {

	WebDriver driver;
	EmployeeActiveStatusPage EAS;
	
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

		EAS = new EmployeeActiveStatusPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"regression, functional"})
		public void TS0127() throws InterruptedException {
			EAS.ExportExcelFile();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0128() throws InterruptedException {
	    	EAS.ExportPDFFile();
	    }
		
	    @Test(groups={"regression, functional"})
		public void TS0129() throws InterruptedException {
			EAS.LocationFilter();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0130() throws InterruptedException {
	    	 EAS.DepartmentFilter();
	    }
	    
	    @Test(groups={"regression, functional"})
		public void TS0131() throws InterruptedException {
			EAS.DesignationFilter();
		}
	    
	    @Test(groups={"regression, functional"})
		public void TS0132() throws InterruptedException {
			EAS.DeviceFilter();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0133() throws InterruptedException {
	    	 EAS.StatusFilter();
	    }
		
	   
	    
	    @AfterMethod
	    public void TearDown()
	    {
		  driver.quit();
	    }
}
