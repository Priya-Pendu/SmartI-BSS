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
import ReportsPageObject.DepartmentReportPage;

public class DepartmentReportTest {

	WebDriver driver;
	DepartmentReportPage DR;
	
	@BeforeMethod
	public void Setup()
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

		DR = new DepartmentReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	@Test(groups="master")
	public void TS0100() throws InterruptedException
	{
		DR.ExportExcel();
	}
	
	@Test(groups="master")
	public void TS0101() throws InterruptedException 
	{
		DR.ExportPDF();
	}
	
	@Test(groups="master")
	public void TS0102() throws InterruptedException 
	{
		DR.VerifySearch("Sales", "New1 Code");
	}
	
	@Test(groups="master")
	public void TS0103() throws InterruptedException {
		 DR.VerifyDivisionFilter();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
