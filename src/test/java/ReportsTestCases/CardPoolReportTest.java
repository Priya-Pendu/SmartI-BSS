package ReportsTestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import ReportsPageObject.CardPoolReportPage;
import Utilities.BaseTest;

public class CardPoolReportTest extends BaseTest {
	CardPoolReportPage CR;
	LoginPage lp;
	
	@BeforeMethod (alwaysRun = true)
	public void Setup()
	{
		CR = new CardPoolReportPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.LginCredentials("tata", "Smarti@321");		
	}
	
	// smoke , regression , functional , negative

	@Test(groups={"regression , functional"})
	public void TS0118() throws InterruptedException {
		CR.LocationFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0119() throws InterruptedException {
		CR.DepartmentFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0120() throws InterruptedException {
		CR.DesignationFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0121() throws InterruptedException {
		CR.EmployeeFilterValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0122() throws InterruptedException
	{
		CR.CardStatusValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0123() throws InterruptedException
	{
		CR.CardTypeValidation();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0125() throws InterruptedException
	{
		CR.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0126() throws InterruptedException
	{
		CR.ExportPDF();
	}
	
}
