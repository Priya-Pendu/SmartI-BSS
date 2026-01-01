package MasterTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import MasterPage.LocationPage;
import Utilities.DownloadUtil;


public class LocationTest {

	
WebDriver driver;
LocationPage locp;

	@BeforeTest
	void setup()
	{
		
		driver = DownloadUtil.getChromeDriverWithDownloadFolder();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:915/");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
	    lp.LginCredentials("tata", "Smarti@123");
	    locp = new LocationPage(driver);
	    
		
	}

	
	@Test (priority = 1, groups="master")
	public void TS0001() throws InterruptedException
	{
		locp.CheckLocationInOtherCompany("Test6", "1006");
	}
	
	@Test(priority=2, groups="master")
	public void TS0002() 
	{
		locp.VerifyNewLocationPage();
	}
	
	
	@Test (priority = 3, groups="master")
	void TS0003() throws InterruptedException
	{
		
	    locp.VerifyAddLocation("Test8", "1008");
	}
	
	@Test (priority = 4, groups="master")
	public void TS0004() throws InterruptedException
	{
		locp.VerifyMaxCharLimit();
	}
	
	@Test (priority = 5, groups="master")
	public void TS0005() throws InterruptedException
	{
		locp.viewExistingLocation("Mumbai");
	}
	
	
	@Test(priority= 6, groups="master")
	public void TS0006() throws InterruptedException
	{
		locp.EditLocation("Banglore", "Banglore","BNGL", "Test");
	}
	
	@Test(priority=7, groups="master")
	public void TS0008() throws InterruptedException
	{
		locp.VerifyExcelbtn();
	}
	
	@Test(priority=8, groups="master")
	public void TS0009() throws InterruptedException
	{
		locp.VerifyPDFbtn();
	}
	
	@Test(priority=9, groups="master")
	public  void TS0010() throws InterruptedException 
	{
		locp.VerifySearchLocation("Mumbai", "BWD01");
	}
	
	@Test(priority=10, groups="master")
	public void TS0011() throws InterruptedException
	{
		locp.VerifyDuplicateLocAdd("Mumbai", "BWD01");
	}
	
	@Test(priority=11, groups="master")
	public void TS0012() throws InterruptedException
	{
		locp.verifyCustomerFieldIsNotEditable("SmartiSystems");
	}
	
	@Test(priority=12, groups="master")
	public void TS0013() throws InterruptedException
	{
		locp.verifyIsSharedCheckbox();
	}
	
	@Test(priority=13, groups="master")
	public void TS0014() throws InterruptedException
	{
		locp.verifyIsActiveCheckbox();
	}
	
	@Test(priority=14, groups="master")
	public void TS0015()
	{
		locp.verifyMandatoryFields();
	}
	
	@Test(priority=15, groups="master")
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
	
	
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
}
