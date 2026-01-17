package MasterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import MasterPage.RolePageObject;
import Utilities.BaseTest;

public class RoleTest extends BaseTest
{
	RolePageObject RP;
	LoginPage lp;
	
	
	@BeforeMethod(alwaysRun = true)
	public void Setup()
	{

		RP = new RolePageObject(driver);
	
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}


	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void NewRole() throws InterruptedException
	{
		RP.AddRole("Recipients");
	}
	
	@Test(groups={"regression , functional"})
	public void UpdateRole() throws InterruptedException
	{
		RP.EditRole("Recipients", "Recipients2");
	}
	
}
