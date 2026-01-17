package ReportsTestCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.EmployeeEntityAccessPage;
import Utilities.BaseTest;

public class EmployeeEntityAccessTest extends BaseTest {

	EmployeeEntityAccessPage EEAP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
		EEAP = new EmployeeEntityAccessPage(driver);
		
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
	
	}
	
	// smoke , regression , functional , negative
	
	    @Test(groups={"regression , functional "})
		public void TS0136() throws InterruptedException
		{
			EEAP.ExportToExcel();
		}
		
	    @Test(groups={"regression, functional"})
	    public void TS0137() throws InterruptedException
	    {
	    	EEAP.GeneratePDFReport();
	    }
	    
	   @Test(groups={"regression, functional"})
	   public void TS0138() throws InterruptedException {
		EEAP.LocationFilterValidation();
	   }
	
	   @Test(groups={"regression, functional"})
	   public void TS0139() throws InterruptedException {
		   EEAP.DepartmentFilterValidation();
	   }
	   
	    @Test(groups={"regression, functional"})
		public void TS0140() throws InterruptedException {
			EEAP.DesignationFilterValidation();
		}
	   
	    @Test(groups={"regression, functional"})
	   	public void TS0141() throws InterruptedException {
	   		EEAP.EntityFilterValidation();
	   	}
	   	
	    @Test(groups={"regression, functional"})
		public void TS0142() throws InterruptedException {
			EEAP.EmployeeFilterValidation();
		 }

}
