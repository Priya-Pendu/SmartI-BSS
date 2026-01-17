package LoginTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BaseTest;

public class LoginTest  extends BaseTest{

	
	LoginPage lp;
	

	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
	
		lp = new LoginPage(driver);
			
		lp.LginCredentials("tata", "Smarti@321");
	
	}

		
	@Test(groups="smoke")
	void testLogin()
	{
		lp.LginCredentials("admin","admin");
	}
	
	@AfterMethod
	void teardown()
	{
		driver.quit();
	}
}
