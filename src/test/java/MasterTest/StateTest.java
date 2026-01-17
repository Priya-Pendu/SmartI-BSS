package MasterTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.StatePage;
import Utilities.BaseTest;

public class StateTest extends BaseTest
{
	
	StatePage SP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
     	SP = new StatePage(driver);
	
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
	
	}

	// smoke , regression , functional , negative
	
	@Test(groups="smoke")
	public void TS0073() throws InterruptedException
	{
		SP.VerifyNewStatePage();
	}
	
	@Test(groups={"regression , functional"})
	void TS0074() throws InterruptedException
	{
		SP.AddState("TEst123", "India");
	}
	
	@Test(groups="smoke")
	public void TS0075() throws InterruptedException {
		SP.ViewState("TEst123");
	}
	
	@Test(groups={"regression , functional"})
	void TS0076() throws InterruptedException
	{
		SP.EditState("ABC", "TEst321");
	}
	
	@Test(groups="smoke")
	public void TS0077() throws InterruptedException {
		SP.VerifySearch("TEst321");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0078() throws InterruptedException
	{
		SP.CheckStateAccrosCompanies("Test");
	}
	

}
