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
import MasterPage.DesignationPage;

public class DesginationTest 
{
	WebDriver driver;
	DesignationPage DP;
	
	@BeforeTest
	void login()
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
		DP = new DesignationPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@123");
	}
	
	//@Test(priority=1)
	public void TS0062()
	{
		DP.VerifyDesignationPage();
	}
	
	//@Test(priority=2)
	void TS0063() throws InterruptedException
	{
		DP.AddDesignation("sales-01", "Sales", "Add");	
	}
	
	//@Test(priority=3)
	public void TS0064() throws InterruptedException {
		DP.ViewDesignation("Developer");
	}
	
	//@Test(priority=4)
	public void updateDesignation() throws InterruptedException
	{
		DP.EditDesignation("Software Developer", "0003", "Software Developer");
	}
	
	//@Test(priority=5)
	public void TS0067() throws InterruptedException
	{
		DP.VerifyExcelbtn();
	}
	
	//@Test(priority=6)
	public void TS0068() throws InterruptedException {
		DP.VerifyPDFbtn();
	}
	
	@Test(priority=7)
	public void TS0069() throws InterruptedException{
		DP.VerifySearch("HOD","Soft-05");
	}
	
	@AfterTest
	void logut()
	{
		driver.quit();
	}
}
