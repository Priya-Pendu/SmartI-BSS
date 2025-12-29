package AdministrationTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AdministrationPage.UserPage;
import LoginTest.LoginPage;
import ReportsPageObject.CardPoolReportPage;

public class UserTest {

	WebDriver driver;
	UserPage UP;
	
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
		UP = new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	
	//@Test(priority=1, groups ="Master")
	public void TS0194() throws InterruptedException
	{
		//String User, String DisplayN, String Mail, String EmailDomainData,String Pass
		UP.AddUser("UserTest", "UserTest", "testmail", "gmail.com", "Smarti@12345");
	}
	
	//@Test(priority=2, groups ="Master")
	public void TS0195() throws InterruptedException
	{
		
	    UP.CreateNUserWithMiscOption("TestUser", "TestUser", "testusermail", "gmail.com" , "Smarti@12345", "365", "Security");
	}
	
	@Test(priority=3, groups ="Master")
	public void TS0196() throws InterruptedException
	{
		UP.ViewUserForm("Infosys");
	}
	
	@AfterTest(groups="master")
	public void teardown()
	{
		driver.quit();
	}
}
