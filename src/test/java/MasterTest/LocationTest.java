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
import MasterPage.LocationPage;
import Utilities.DownloadUtil;


public class LocationTest {

	
WebDriver driver;
LocationPage locp;

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

		locp = new LocationPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}

	// smoke , regression , functional , negative
	
	@Test (groups={"regression , functional"})
	public void TS0001() throws InterruptedException
	{
		locp.CheckLocationInOtherCompany("Test6", "1006");
	}
	
	@Test(groups="smoke")
	public void TS0002() 
	{
		locp.VerifyNewLocationPage();
	}
	
	
	@Test (groups={"regression , functional"})
	void TS0003() throws InterruptedException
	{
		
	    locp.VerifyAddLocation("Test8", "1008");
	}
	
	@Test (groups={"regression , functional"})
	public void TS0004() throws InterruptedException
	{
		locp.VerifyMaxCharLimit();
	}
	
	@Test (groups={"regression , functional"})
	public void TS0005() throws InterruptedException
	{
		locp.viewExistingLocation("Mumbai");
	}
	
	
	@Test(groups={"regression , functional"})
	public void TS0006() throws InterruptedException
	{
		locp.EditLocation("Banglore", "Banglore","BNGL", "Test");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0008() throws InterruptedException
	{
		locp.VerifyExcelbtn();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0009() throws InterruptedException
	{
		locp.VerifyPDFbtn();
	}
	
	@Test(groups="smoke")
	public  void TS0010() throws InterruptedException 
	{
		locp.VerifySearchLocation("Mumbai", "BWD01");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0011() throws InterruptedException
	{
		locp.VerifyDuplicateLocAdd("Mumbai", "BWD01");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0012() throws InterruptedException
	{
		locp.verifyCustomerFieldIsNotEditable("SmartiSystems");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0013() throws InterruptedException
	{
		locp.verifyIsSharedCheckbox();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0014() throws InterruptedException
	{
		locp.verifyIsActiveCheckbox();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0015()
	{
		locp.verifyMandatoryFields();
	}
	
	@Test(groups="smoke")
	public void TS0016() throws InterruptedException
	{
		locp.VerifyRefreshButton();
	}
	
	/*
	@Test (priority = 3 )
	void DeleteLocation() throws InterruptedException
	{
		locp.DeleteLocation("Kalyan");
	}
	*/
	
	
	@AfterMethod
	void teardown()
	{
		driver.quit();
	}
}
