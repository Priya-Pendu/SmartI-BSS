package AdministrationTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AdministrationPage.RolesPage;
import LoginTest.LoginPage;
import Utilities.BaseTest;

public class RolesTest extends BaseTest {

	RolesPage RP;
	LoginPage lp;
	
	
	@BeforeMethod (alwaysRun = true)
	public void Login()
	{

		RP = new RolesPage(driver);
				        
	    lp = new LoginPage(driver);
	  	    
		lp.LginCredentials("tata", "Smarti@321");
	
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"functional","Regression"})
		public void TS0191() throws InterruptedException {
			RP.AddNewRole("TestRole1");
		}
		
	   @Test(groups={"Regression"})
	   public void TS0192() throws InterruptedException {
		   RP.ViewRolesForm("TestRole1");
	   }
	    
	   @Test(groups={"functional","Regression"})
	   public void TS0193() throws InterruptedException {
		   RP.UpdateRolesData("TestRole1", "UpdatedTestRole1");
	   }
	   

}
