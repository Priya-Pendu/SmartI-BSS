package ReportsTestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import ReportsPageObject.DesignationReportPage;
import Utilities.BaseTest;


public class DesignationReportTest extends BaseTest{

	DesignationReportPage DR;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{

		DR = new DesignationReportPage(driver);
		
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0095() throws InterruptedException 
	{
		DR.VerifySearch("HOD");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0096() throws InterruptedException
	{
		DR.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0097() throws InterruptedException 
	{
		DR.ExportPDF();
	}
	

}
