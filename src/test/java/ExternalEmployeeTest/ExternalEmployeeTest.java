package ExternalEmployeeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExternalEmployeePage.ExternalEmoployees;
import LoginTest.LoginPage;
import LoginTest.LoginTest;

public class ExternalEmployeeTest
{
	WebDriver driver;
	ExternalEmoployees EP;
	
	@BeforeTest
	public void Login()
	{
		driver = new ChromeDriver();
		driver.get("http://192.168.0.4:5292/Account/Login?ReturnUrl=%2f");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		EP = new ExternalEmoployees(driver);
	}

	@Test (priority =1 )
	public void AddExternalEmp() throws Exception
	{					
		
		/*public void AddEMP(String Org,String Location, String Divi, String Dept, String SubDept, String Designation,
			String EmpC,String Salutation, String FirstName, String MiddleN, String LastName, String Gender,
			String Mstatus, String Emptype, String ManagerName, 
			String MobileNo, String EmailAdd, String OfficialNo, 
			String ResiN, String EMGNo,
			String DateOFBirth, String Date,  String RGMonth, String RGYear, String RGDate, 
			String BloodG, String AdharNumber  ) throws Exception */
		
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("One96", "Chirag@123");
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
