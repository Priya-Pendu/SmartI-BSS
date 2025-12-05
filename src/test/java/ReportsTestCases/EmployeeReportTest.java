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
import ReportsPageObject.EmployeeReportPage;

public class EmployeeReportTest {
	WebDriver driver;
	EmployeeReportPage EP;
	
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
		EP = new EmployeeReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	
	@Test(priority=1, groups="master")
	public void TS0109() throws InterruptedException
	{
		EP.ExportExcel();
	}
	
	//@Test(priority=2)
	public void TS0110() throws InterruptedException
	{
		EP.ExportPDF();
	}
	
	@Test(priority=3,groups="master")
	public void TS0112() throws InterruptedException
	{
		EP.LocationFilterValidation();
	}
	
	//@Test(priority=4)
	public void TS0113() throws InterruptedException
	{
		EP.DivisionFilterValidation();
	}
	
	//@Test(priority=5)
	public void TS0114() throws InterruptedException
	{
		EP.DepartFilterValidation();
	} 
	
	@Test(priority=6)
	public void TS0115() throws InterruptedException
	{
		EP.DesigFlterValidation();
	}
	
	@AfterTest(groups="master")
	public void teardown()
	{
		driver.quit();
	}

}
