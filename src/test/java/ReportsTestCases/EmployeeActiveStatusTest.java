package ReportsTestCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.EmployeeActiveStatusPage;
import Utilities.BaseTest;

public class EmployeeActiveStatusTest extends BaseTest {

	
	EmployeeActiveStatusPage EAS;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
	
		EAS = new EmployeeActiveStatusPage(driver);
		
		lp = new LoginPage(driver);
	
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"regression, functional"})
		public void TS0127() throws InterruptedException {
			EAS.ExportExcelFile();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0128() throws InterruptedException {
	    	EAS.ExportPDFFile();
	    }
		
	    @Test(groups={"regression, functional"})
		public void TS0129() throws InterruptedException {
			EAS.LocationFilter();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0130() throws InterruptedException {
	    	 EAS.DepartmentFilter();
	    }
	    
	    @Test(groups={"regression, functional"})
		public void TS0131() throws InterruptedException {
			EAS.DesignationFilter();
		}
	    
	    @Test(groups={"regression, functional"})
		public void TS0132() throws InterruptedException {
			EAS.DeviceFilter();
		}
	    
	    @Test(groups={"regression, functional"})
	    public void TS0133() throws InterruptedException {
	    	 EAS.StatusFilter();
	    }
		

}
