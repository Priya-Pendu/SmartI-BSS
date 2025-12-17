package MasterTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import LoginTest.LoginPage;
import MasterPage.DepartmentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepartmentTest 
{
	WebDriver driver;
	DepartmentPage Dp;

	@BeforeTest
	public void setup()
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Dp = new DepartmentPage(driver);
		LoginPage lp = new LoginPage(driver);
	    lp.LginCredentials("tata", "Smarti@123");
	}

	//@Test(priority=1)
	public void TS0039() throws InterruptedException
	{
		
		Dp.AddDepartment("Thane", "Division B", "Sales-02", "Sales Department", "Test");
	}
	
	//@Test(priority=2)
	public void TS0040() throws InterruptedException 
	{
		Dp.ViewExistDepa("Sales Department");
	}
	
	//@Test(priority=3)
	public void TS0041() throws InterruptedException
	{
		Dp.EditDepartment("Account Department", "Thane", "Division C", "New1 Code", "Software1 Department");
	}
	
	//@Test(priority=4)
	public void TS0042() throws InterruptedException 
	{
		Dp.ExportExcel();
	}
	
	//@Test(priority=5)
	public void TS0043() throws InterruptedException {
		Dp.ExportPDF();
	}
	
	//@Test(priority=6)
	public void TS0044() throws InterruptedException
	{
		Dp.SearchDepartment("Software1 Department", "New1 Code");
	}
	
	//@Test(priority=7)
	public void TS0045() throws InterruptedException
	{
		Dp.CheckDepartmentInMultipleCompanies("Software1 Department");
	}
	
	//@Test(priority=8)
	public void TS0046() throws InterruptedException
	{
		Dp.VerifyNDeptPage();
	}
	
	//@Test(priority=9)
	public void TS0047()
	{
		Dp.DiviFilter();
	}
	
	@Test(priority=10)
	public void TS0049()
	{
		Dp.VerifyDiviList();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
