package MasterTest;
import LoginTest.LoginPage;
import MasterPage.DepartmentPage;
import Utilities.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DepartmentTest extends BaseTest
{
	
	DepartmentPage Dp;
	LoginPage lp;

	@BeforeMethod(alwaysRun = true)
	public void Login()
	{
		
		Dp = new DepartmentPage(driver);	
		
		lp = new LoginPage(driver);
				
		lp.LginCredentials("tata", "Smarti@321");
		
	}

	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void TS0039() throws InterruptedException
	{
		
		Dp.AddDepartment("Thane", "Division B", "Sales-02", "Sales Department", "Test");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0040() throws InterruptedException 
	{
		Dp.ViewExistDepa("Sales Department");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0041() throws InterruptedException
	{
		Dp.EditDepartment("Account Department", "Thane", "Division C", "New1 Code", "Software1 Department");
	}
	
	@Test(groups={"regression , functional"})
	public void TS0042() throws InterruptedException 
	{
		Dp.ExportExcel();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0043() throws InterruptedException {
		Dp.ExportPDF();
	}
	
	@Test(groups={"regression, smoke"})
	public void TS0044() throws InterruptedException
	{
		Dp.SearchDepartment("Software1 Department", "New1 Code");
	}
	
	@Test(groups={"functional , negative"})
	public void TS0045() throws InterruptedException
	{
		Dp.CheckDepartmentInMultipleCompanies("Software1 Department");
	}
	
	@Test(groups={"smoke, regression"})
	public void TS0046() throws InterruptedException
	{
		Dp.VerifyNDeptPage();
	}
	
	@Test(groups={"regression , functional"})
	public void TS0047()
	{
		Dp.DiviFilter();
	}
	
	@Test(groups={"regression, negative"})
	public void TS0049()
	{
		Dp.VerifyDiviList();
	}
	
	
}
