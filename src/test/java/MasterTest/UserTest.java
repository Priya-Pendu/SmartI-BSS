package MasterTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.UserPageObject;


public class UserTest 
{
	WebDriver driver;
	UserPageObject UP;
	
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

		UP = new UserPageObject(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	@Test(groups="master")
	public void AddUser() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("Smarti", "Smarti@123");
		UP.AddUser("Test", "Priya", "priyapendu", "Priya@12345");
	}
	
	@Test(groups="master")
	public void UpdateUser() throws InterruptedException
	{
		UP.EditUser("Test", "Test1", "Test1", "50");
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	

}
