package MasterTest;

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
import MasterPage.SubDepartmentPage;

public class SubDepartmentTest
{
	WebDriver driver;
	SubDepartmentPage SD;
	
	@BeforeTest
	public void login()
	{
		Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "D:\\Priya\\BSS_Automation_Files\\Eclipse-Workspace\\SmartISystems-BSS\\SmartI-BSS\\SmartI-BSS\\download");
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("plugins.always_open_pdf_externally", true); // auto-download PDFs

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        
		driver = new ChromeDriver(options);
		driver.get("http://localhost:915/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		SD = new SubDepartmentPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@123");
	}
	
	//@Test(priority=1)
	public void TS0051()
	{
		SD.VerifySubDepartmentPage();
	}
	
	//@Test (priority=2)
	public void SubDepartment() throws InterruptedException
	{
		
		SD.AddSubDepartment("Sales Department", "SubD-10", "Pre-Sales", "Remark");
	}
	
	//@Test(priority=3)
	public void TS0053() throws InterruptedException {
		SD.ViewSubDept("Pre-Sales");
	}
	
    //@Test(priority=4)
	public void UpdateDepartment() throws InterruptedException
	{
		SD.EditDeparment("ACS KIAM", "Sales Department", "200", "ACS KIAM");
	}
	
	//@Test(priority=5)
	public void TS0056() throws InterruptedException
	{
		SD.ExportExcel();
	}
	
	//@Test(priority=6)
	public void TS0057() throws InterruptedException {
		SD.ExportPDF();
	}
	
	//@Test(priority=7)
	public void TS0058() throws InterruptedException {
		SD.VerifySearch("Automation Testing", "SubD-01");
	}
	
	//@Test(priority=8)
	public void TS0059() throws InterruptedException {
		SD.VerifySubDeptAcrossCompanies("Automation Testing");
	}
	
	@Test(priority=9)
	public void TS0060() throws InterruptedException {
		SD.MandatoryFieldCheck();
	}
	@AfterTest
	public void Logout()
	{
		driver.quit();
	}
}
