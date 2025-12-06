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
import ReportsPageObject.DepartmentReportPage;
import ReportsPageObject.DivisionReportPage;

public class DivisionReportTest {

	WebDriver driver;
	DivisionReportPage DR;
	
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
		DR = new DivisionReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	//@Test(priority=1)
	public void TS0105() throws InterruptedException {
		DR.ExportExcel();
	}
	
	//@Test(priority=2)
	public void TS0106() throws InterruptedException {
		DR.ExportPDF();
	}
	
	@Test(priority=3)
	public void TS0107() throws InterruptedException {
		DR.VerifySearch("Division Test", "Divi-B" );
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
