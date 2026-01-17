package ExternalEmployeeTest;

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

import AdministrationPage.UserPage;
import ExternalEmployeePage.ExternalEmoployees;
import LoginTest.LoginPage;
import LoginTest.LoginTest;
import Utilities.BaseTest;

public class ExternalEmployeeTest extends BaseTest
{
	
	ExternalEmoployees EP;
	LoginPage lp;
	
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

		EP = new ExternalEmoployees(driver);
		
		
		 lp = new LoginPage(driver);
		
		
		lp.LginCredentials("tata", "Smarti@321");
	}
	
	// smoke , regression , functional , negative

	@Test (groups ={"regression" , "functional"} )
	public void AddExternalEmp() throws Exception
	{					
		
		/*public void AddEMP(String Org,String Location, String Divi, String Dept, String SubDept, String Designation,
			String EmpC,String Salutation, String FirstName, String MiddleN, String LastName, String Gender,
			String Mstatus, String Emptype, String ManagerName, 
			String MobileNo, String EmailAdd, String OfficialNo, 
			String ResiN, String EMGNo,
			String DateOFBirth, String Date,  String RGMonth, String RGYear, String RGDate, 
			String BloodG, String AdharNumber  ) throws Exception */
		
		
		EP.AddEMP( "vivo","Default","Default", "Default","Default","junior devloper", "Emp-01", "Miss", 
				"Swapnali", "radheshyam", "Yadav", "Female","Unmarried",
				"Employee", "Chirag","5656565656", "swapnaliyadav",
				"2323232323",  "323", "8956231203", 
				"11/15/2000", "03/29/2025", "May","2026","15", "2026/04/08",
				"O-" , "123456789012");
		EP.Address("Bhiwandi", "India", "Maharashtra","thane", "421032", "Bhiwandi","India","Maharashtra","thane","421032");
		EP.AdvanceSettings("Smarti");
		EP.EmployeeCardManagement("Regular", "6665666666", "04/08/2025");
		//EP.DateOfBirth("March", "2025", "1");
	}
	
	public void EditExternalEmp()
	{
		
	}
	
	@AfterTest
	public void EndSession()
	{
		driver.quit();
	}
}
