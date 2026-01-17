package ReportsTestCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import ReportsPageObject.DepartmentReportPage;
import Utilities.BaseTest;

public class DepartmentReportTest extends BaseTest {

	DepartmentReportPage DR;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Setup()
	{

		DR = new DepartmentReportPage(driver);
		        
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0100() throws InterruptedException
	{
		DR.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0101() throws InterruptedException 
	{
		DR.ExportPDF();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0102() throws InterruptedException 
	{
		DR.VerifySearch("Sales", "New1 Code");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0103() throws InterruptedException {
		 DR.VerifyDivisionFilter();
	}
	
}
