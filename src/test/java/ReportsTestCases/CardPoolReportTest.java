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
import ReportsPageObject.DivisionReportPage;

public class CardPoolReportTest {
	WebDriver driver;
	CardPoolReportPage CR;
	
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
		CR = new CardPoolReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}

	@Test(priority=1, groups="master")
	public void TS0118() throws InterruptedException {
		CR.LocationFilterValidation();
	}
	
	@Test(priority=2, groups ="Master")
	public void TS0119() throws InterruptedException {
		CR.DepartmentFilterValidation();
	}
	
	@Test(priority=3, groups="master")
	public void TS0120() throws InterruptedException {
		CR.DesignationFilterValidation();
	}
	
	@Test(priority=4, groups="master")
	public void TS0121() throws InterruptedException {
		CR.EmployeeFilterValidation();
	}
	
	@Test(priority=5, groups ="Master")
	public void TS0122() throws InterruptedException
	{
		CR.CardStatusValidation();
	}
	
	@Test(priority=6, groups="master")
	public void TS0123() throws InterruptedException
	{
		CR.CardTypeValidation();
	}
	
	@Test(priority=7, groups="master")
	public void TS0125() throws InterruptedException
	{
		CR.ExportExcel();
	}
	
	@Test(priority=8, groups="master")
	public void TS0126() throws InterruptedException
	{
		CR.ExportPDF();
	}
	
	@AfterTest (groups="master")
	public void teardown()
	{
		driver.quit();
	}
}
