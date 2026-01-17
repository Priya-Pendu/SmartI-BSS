package MasterTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.SubDepartmentPage;
import Utilities.BaseTest;

public class SubDepartmentTest extends BaseTest
{
	
	SubDepartmentPage SD;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
		SD = new SubDepartmentPage(driver);
	
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups="smoke")
	public void TS0051()
	{
		SD.VerifySubDepartmentPage();
	}
	
	@Test (groups={"regression , functional"})
	public void SubDepartment() throws InterruptedException
	{
		
		SD.AddSubDepartment("Sales Department", "SubD-10", "Pre-Sales", "Remark");
	}
	
	@Test(groups="regression")
	public void TS0053() throws InterruptedException {
		SD.ViewSubDept("Pre-Sales");
	}
	
    @Test(groups={"regression , functional"})
	public void UpdateDepartment() throws InterruptedException
	{
		SD.EditDeparment("ACS KIAM", "Sales Department", "200", "ACS KIAM");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0056() throws InterruptedException
	{
		SD.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0057() throws InterruptedException {
		SD.ExportPDF();
	}
	
	@Test(groups="regression")
	public void TS0058() throws InterruptedException {
		SD.VerifySearch("Automation Testing", "SubD-01");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0059() throws InterruptedException {
		SD.VerifySubDeptAcrossCompanies("Automation Testing");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0060() throws InterruptedException {
		SD.MandatoryFieldCheck();
	}
	
}
