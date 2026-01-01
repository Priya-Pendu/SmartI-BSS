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

public class DepartmentReportTest {

	WebDriver driver;
	DepartmentReportPage DR;
	
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
		DR = new DepartmentReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	@Test(priority=1, groups="master")
	public void TS0100() throws InterruptedException
	{
		DR.ExportExcel();
	}
	
	@Test(priority=2, groups="master")
	public void TS0101() throws InterruptedException 
	{
		DR.ExportPDF();
	}
	
	@Test(priority=3, groups="master")
	public void TS0102() throws InterruptedException 
	{
		DR.VerifySearch("Sales", "New1 Code");
	}
	
	@Test(priority=4, groups="master")
	public void TS0103() throws InterruptedException {
		 DR.VerifyDivisionFilter();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
