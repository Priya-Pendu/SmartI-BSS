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
import ReportsPageObject.TransactionalEventPage;

public class TransactionalEventTest {

	WebDriver driver;
	TransactionalEventPage TranEnt;
	
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

		TranEnt = new TransactionalEventPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"regression , functional"})
		public void TS0157() throws InterruptedException {
			TranEnt.ExportToExcel();
		}
	   
	    @Test(groups={"regression , functional"})
	    public void TS0158() throws InterruptedException {
	    	TranEnt.GeneratePDFReport();
	    }
	    
	    @AfterMethod
	    public void TearDown()
	    {
		  driver.quit();
	    }
}
