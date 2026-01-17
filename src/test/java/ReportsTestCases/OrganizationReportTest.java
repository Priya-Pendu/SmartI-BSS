package ReportsTestCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.OrganizationReportPage;
import Utilities.BaseTest;


public class OrganizationReportTest extends BaseTest
{
	OrganizationReportPage MR;
	LoginPage lp;
	
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		MR = new OrganizationReportPage(driver);
	
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups="smoke")
	public void TS0090 () throws InterruptedException
	{
		MR.VerifySearchBar("dfd", "WHO-05");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0091() throws InterruptedException {
		MR.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0092() throws InterruptedException
	{
		MR.ExportPDF();
	}
	
	@Test(groups={"regression , functional"})
	public void ReportOrganization() throws InterruptedException
	{
		MR.VerifyLockationDrop("Mumbai");	
	}

}
