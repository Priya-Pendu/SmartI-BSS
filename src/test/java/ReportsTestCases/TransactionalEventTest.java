package ReportsTestCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.TransactionalEventPage;
import Utilities.BaseTest;

public class TransactionalEventTest extends BaseTest{

	TransactionalEventPage TranEnt;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		TranEnt = new TransactionalEventPage(driver);		
		lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	    // smoke , regression , functional , negative
	
	    @Test(groups={"regression , functional"})
		public void TS0157() throws InterruptedException {
			TranEnt.ExportToExcel();
		}
	   
	    @Test(groups={"regression , functional"})
	    public void TS0158() throws InterruptedException {
	    	TranEnt.GeneratePDFReport();
	    }
	   
}
