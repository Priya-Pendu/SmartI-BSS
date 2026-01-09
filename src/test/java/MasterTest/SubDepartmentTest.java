package MasterTest;

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
import MasterPage.StatePage;
import MasterPage.SubDepartmentPage;

public class SubDepartmentTest
{
	WebDriver driver;
	SubDepartmentPage SD;
	
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

		SD = new SubDepartmentPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	@Test(groups="master")
	public void TS0051()
	{
		SD.VerifySubDepartmentPage();
	}
	
	@Test (groups="master")
	public void SubDepartment() throws InterruptedException
	{
		
		SD.AddSubDepartment("Sales Department", "SubD-10", "Pre-Sales", "Remark");
	}
	
	@Test(groups="master")
	public void TS0053() throws InterruptedException {
		SD.ViewSubDept("Pre-Sales");
	}
	
    @Test(groups="master")
	public void UpdateDepartment() throws InterruptedException
	{
		SD.EditDeparment("ACS KIAM", "Sales Department", "200", "ACS KIAM");
	}
	
	@Test(groups="master")
	public void TS0056() throws InterruptedException
	{
		SD.ExportExcel();
	}
	
	@Test(groups="master")
	public void TS0057() throws InterruptedException {
		SD.ExportPDF();
	}
	
	@Test(groups="master")
	public void TS0058() throws InterruptedException {
		SD.VerifySearch("Automation Testing", "SubD-01");
	}
	
	@Test(groups="master")
	public void TS0059() throws InterruptedException {
		SD.VerifySubDeptAcrossCompanies("Automation Testing");
	}
	
	@Test(groups="master")
	public void TS0060() throws InterruptedException {
		SD.MandatoryFieldCheck();
	}
	
	@AfterMethod
	public void Logout()
	{
		driver.quit();
	}
}
