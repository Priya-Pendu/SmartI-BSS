package ReportsTestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.DivisionReportPage;
import Utilities.BaseTest;

public class DivisionReportTest extends BaseTest {

	DivisionReportPage DR;
	LoginPage lp;
	
	@BeforeMethod (alwaysRun = true)
	public void Login()
	{
    	DR = new DivisionReportPage(driver);
		
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0105() throws InterruptedException {
		DR.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0106() throws InterruptedException {
		DR.ExportPDF();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0107() throws InterruptedException {
		DR.VerifySearch("Division Test", "Divi-B" );
	}
	
}
