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
import MasterPage.DivisionPage;

public class DivisionTest 
{
		WebDriver driver;
		DivisionPage DP;
		
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

			DP = new DivisionPage(driver);
			LoginPage lp = new LoginPage(driver);
			lp.LginCredentials("tata", "Smarti@321");

			
		}

		
		@Test(groups="master")
		public void TS0030() throws InterruptedException
		{
			DP.VerifyNewDivisionPage();
			
		}
		
		@Test (groups="master")
		public void TS0031() throws InterruptedException
		{
		    DP.AddDivision("Kalyan", "New-Divi05", "R&D05", "Testing Purpose"); 
		}
		
		
		@Test(groups="master")
		public void TS0032() throws InterruptedException
		{
			DP.ViewExistDivi("Marketing");
		}
		
		@Test(groups="master")
		public void TS0033() throws InterruptedException
		{
			DP.EditDivision("Software-01", "Mumbai	", "New-Divi02", "Software-01");
		}
		
		@Test(groups="master")
		public void TS0034() throws InterruptedException
		{
			DP.ExportExcel();
		}
		
		@Test(groups="master")
		public void TS0035() throws InterruptedException
		{
			DP.ExportPDF();
		}
		
		@Test(groups="master")
		public void TS0036() throws InterruptedException
		{
			DP.VerifySearchBar("Division C", "Divi-B");
		}
		
		@AfterMethod
		public void Logout()
		{
			driver.quit();
		}
}
