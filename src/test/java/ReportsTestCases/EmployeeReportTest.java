package ReportsTestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import ReportsPageObject.EmployeeReportPage;
import Utilities.BaseTest;

public class EmployeeReportTest extends BaseTest {
	EmployeeReportPage EP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
		EP = new EmployeeReportPage(driver);
		
	    lp = new LoginPage(driver);
	
		lp.LginCredentials("tata", "Smarti@321");		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0109() throws InterruptedException
	{
		EP.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0110() throws InterruptedException
	{
		EP.ExportPDF();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0112() throws InterruptedException
	{
		EP.LocationFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0113() throws InterruptedException
	{
		EP.DivisionFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0114() throws InterruptedException
	{
		EP.DepartFilterValidation();
	} 
	
	@Test(groups={"regression , functional"})
	public void TS0115() throws InterruptedException
	{
		EP.DesigFlterValidation();
	}
	

}
