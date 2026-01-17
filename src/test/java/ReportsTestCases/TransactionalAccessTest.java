package ReportsTestCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.TransactionalAccessPage;
import Utilities.BaseTest;

public class TransactionalAccessTest extends BaseTest {

	TransactionalAccessPage TAP;
	LoginPage lp;
	
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		TAP = new TransactionalAccessPage(driver);
		
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	   @Test(groups={"regression , functional"})
	   public void TS0147() throws InterruptedException {
		   
		   TAP.LocationFilter("Mumbai");
	    }
	
	   
	   @Test(groups={"regression , functional"})
		public void TS0148() throws InterruptedException {

			TAP.DepartmentFilter("Software Department");
		}
	   
	   @Test(groups={"regression , functional"})
		public void TS0149() throws InterruptedException {
			TAP.EmployeeFilter("Shreya Sharma");
		}
		
	   @Test(groups={"regression , functional"})
		public void TS0150() throws InterruptedException {
			TAP.DeviceLocationFilter("Mumbai");
		}
		
	   @Test(groups={"regression , functional"})
		public void TS0151() throws InterruptedException {
			TAP.DeviceFilter("BioSlim12");
		}
		
	   @Test(groups={"regression , functional"})
		public void TS0152() throws InterruptedException {
			TAP.ReaderFilter("BioSlim Reader 1");
		}
		
}
