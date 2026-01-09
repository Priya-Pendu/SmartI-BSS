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

public class StateTest
{
	WebDriver driver;
	StatePage SP;
	
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

		SP = new StatePage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}

	
	@Test(groups="master")
	public void TS0073() throws InterruptedException
	{
		SP.VerifyNewStatePage();
	}
	
	@Test(groups="master")
	void TS0074() throws InterruptedException
	{
		SP.AddState("TEst123", "India");
	}
	
	@Test(groups="master")
	public void TS0075() throws InterruptedException {
		SP.ViewState("TEst123");
	}
	
	@Test(groups="master")
	void TS0076() throws InterruptedException
	{
		SP.EditState("ABC", "TEst321");
	}
	
	@Test(groups="master")
	public void TS0077() throws InterruptedException {
		SP.VerifySearch("TEst321");
	}
	
	@Test(groups="master")
	public void TS0078() throws InterruptedException
	{
		SP.CheckStateAccrosCompanies("Test");
	}
	
	@AfterMethod
	void Logout()
	{
		if (driver != null) {
            driver.quit();
        }
	}

}
