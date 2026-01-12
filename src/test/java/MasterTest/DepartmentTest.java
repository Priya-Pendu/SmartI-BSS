package MasterTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import LoginTest.LoginPage;
import MasterPage.DepartmentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepartmentTest 
{
	WebDriver driver;
	DepartmentPage Dp;

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

		Dp = new DepartmentPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}

	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0039() throws InterruptedException
	{
		
		Dp.AddDepartment("Thane", "Division B", "Sales-02", "Sales Department", "Test");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0040() throws InterruptedException 
	{
		Dp.ViewExistDepa("Sales Department");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0041() throws InterruptedException
	{
		Dp.EditDepartment("Account Department", "Thane", "Division C", "New1 Code", "Software1 Department");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0042() throws InterruptedException 
	{
		Dp.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0043() throws InterruptedException {
		Dp.ExportPDF();
	}
	
	@Test(groups={"regression, smoke"})
	public void TS0044() throws InterruptedException
	{
		Dp.SearchDepartment("Software1 Department", "New1 Code");
	}
	
	@Test(groups={"functional , negative"})
	public void TS0045() throws InterruptedException
	{
		Dp.CheckDepartmentInMultipleCompanies("Software1 Department");
	}
	
	@Test(groups={"smoke, regression"})
	public void TS0046() throws InterruptedException
	{
		Dp.VerifyNDeptPage();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0047()
	{
		Dp.DiviFilter();
	}
	
	@Test(groups={"regression, negative"})
	public void TS0049()
	{
		Dp.VerifyDiviList();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
