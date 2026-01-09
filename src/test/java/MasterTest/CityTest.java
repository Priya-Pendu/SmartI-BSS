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
import MasterPage.CityPage;

public class CityTest 
{
	WebDriver driver;
	CityPage cp;
	
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

		cp = new CityPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}

	// smoke , regression , functional , negative
	
	@Test(groups="smoke")
	public void TS0081()
	{
		cp.VerifyCityPg();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0082() throws InterruptedException
	{
		
		cp.AddCity("Bhiwandi", "India", "Maharashtra");
	}
	
	@Test(groups="regression")
	public void TS0083()
	{
		cp.ViewCity("Bhiwandi");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0084() throws InterruptedException
	{
		cp.EditState("Bhiwandi", "Bhiwandi2");
	}
	
	@Test(groups="regression")
	public void TS0086()
	{
		cp.VerifySearch("Bhiwandi2");
	}
	
	@Test(groups="regression")
	public void TS0087() throws InterruptedException
    {
		cp.VerifyAccrossCompanies("Mumbai");
    }
	
	@Test(groups="regression")
	public void TS0088() throws InterruptedException
	{
		cp.verifyCountryFilter("India");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
