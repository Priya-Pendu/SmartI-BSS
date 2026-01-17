package MasterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.DashboardPage;
import Utilities.BaseTest;

public class DashboardTest extends BaseTest
{
	
	DashboardPage DP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
		DP = new DashboardPage(driver);
		
		
		 lp = new LoginPage(driver);
		 
		 
		lp.LginCredentials("tata", "Smarti@321");

		
	}

	// smoke , regression , functional , negative
	
	@Test(groups={"smoke"})
	public void InActiveEmpCheck()
	{
		DP.InActiveEmp();
	}
	
	@Test(groups={"smoke"})
	public void CriticalEventCheck()
	{
		DP.CriticalEvent();
	}
	
	@Test(groups={"smoke"})
	public void EmoloyeeInCheck()
	{
		DP.EmployeeIN();
	}
	
	@Test(groups={"smoke"})
	public void Tailgatingcount()
	{
		DP.CriticalEvent();
	}
	
	@Test(groups={"smoke"})
	public void UserHourlyAccess()
	{
		DP.UHAccess();
	}
	
	@Test(groups={"smoke"})
	public void Top5MostAccessDevices()
	{
		DP.Top5MAD();
	}
		
}
