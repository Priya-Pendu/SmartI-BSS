package AdministrationTest;

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

import AdministrationPage.RolesPage;
import AdministrationPage.UserPage;
import LoginTest.LoginPage;
import ReportsPageObject.CardPoolReportPage;

public class UserTest {

	WebDriver driver;
	UserPage UP;
	
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

		UP = new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");
	}

	// smoke , regression , functional , negative
	
	@Test(groups ={"regression" , "functional"})
	public void TS0194() throws InterruptedException
	{
		//String User, String DisplayN, String Mail, String EmailDomainData,String Pass
		UP.AddUser("UserTest", "UserTest", "testmail", "gmail.com", "Smarti@12345");
	}
	
	@Test(groups ={"regression" , "functional"})
	public void TS0195() throws InterruptedException
	{
		
	    UP.CreateNUserWithMiscOption("TestUser", "TestUser", "testusermail", "gmail.com" , "Smarti@12345", "365", "Security");
	}
	
	@Test(groups ="regression")
	public void TS0196() throws InterruptedException
	{
		UP.ViewUserForm("Infosys");
	}
	
	@Test(groups = {"functional","regression"})
	public void TS0197() throws InterruptedException {
		
		UP.updateUserForm("UpdatedUser", "UpdatedUserN","UpdatedDispN" ,"updatemail", "gmail.com", "Smarti@54312", "Smarti@54312");
	}
	
	@Test(groups ={"functional","regression"})
	public void TS0198() throws InterruptedException {

		UP.DeleteUser("adf");
	}
	
	
	@AfterMethod(groups="master")
	public void teardown()
	{
		driver.quit();
	}
}
