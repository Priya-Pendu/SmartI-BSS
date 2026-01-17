package MasterTest;




import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.CityPage;
import Utilities.BaseTest;

public class CityTest extends BaseTest
{
	
	CityPage cp;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		cp = new CityPage(driver);
		
		
		lp = new LoginPage(driver);
		
		
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
	

}
