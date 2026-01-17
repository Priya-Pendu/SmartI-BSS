package MasterTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.DesignationPage;
import Utilities.BaseTest;

public class DesginationTest extends BaseTest
{
	DesignationPage DP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		DP = new DesignationPage(driver);
		
		lp = new LoginPage(driver);
			
		lp.LginCredentials("tata", "Smarti@321");		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups="smoke")
	public void TS0062()
	{
		DP.VerifyDesignationPage();
	}
	
	@Test(groups={"regression,functional"})
	void TS0063() throws InterruptedException
	{
		DP.AddDesignation("sales-01", "Sales", "Add");	
	}
	
	@Test(groups="regression")
	public void TS0064() throws InterruptedException {
		DP.ViewDesignation("Developer");
	}
	
	@Test(groups={"regression , functional"})
	public void updateDesignation() throws InterruptedException
	{
		DP.EditDesignation("Software Developer", "0003", "Software Developer");
	}
	
	@Test(groups={"regression, functional"})
	public void TS0067() throws InterruptedException
	{
		DP.VerifyExcelbtn();
	}
	
	@Test(groups={"regression, functional"})
	public void TS0068() throws InterruptedException {
		DP.VerifyPDFbtn();
	}
	
	@Test(groups="smoke")
	public void TS0069() throws InterruptedException{
		DP.VerifySearch("HOD","Soft-05");
	}
	
}
