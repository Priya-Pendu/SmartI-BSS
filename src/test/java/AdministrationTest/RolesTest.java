package AdministrationTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AdministrationPage.RolesPage;
import LoginTest.LoginPage;
import ReportsPageObject.EmployeeEntityAccessPage;

public class RolesTest {

	WebDriver driver;
	RolesPage RP;
	
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
		RP = new RolesPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		}
	
	
	    @Test(priority=1, groups="master")
		public void TS0191() throws InterruptedException {
			RP.AddNewRole("TestRole1");
		}
		
	   @Test(priority=2, groups="master")
	   public void TS0192() throws InterruptedException {
		   RP.ViewRolesForm("TestRole1");
	   }
	    
	   @Test(priority=3, groups="master")
	   public void TS0193() throws InterruptedException {
		   RP.UpdateRolesData("TestRole1", "UpdatedTestRole1");
	   }
	   
	    @AfterTest
		public void TearDown() {
			driver.quit();
		}
		
}
