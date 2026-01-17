package MasterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.OrganizationPage;
import Utilities.BaseTest;

public class OrganizationTest extends BaseTest{

   
    OrganizationPage organizationPage;
    LoginPage lp;

    @BeforeMethod(alwaysRun = true)
	public void Login()
	{

		organizationPage = new OrganizationPage(driver);
		
		
		lp = new LoginPage(driver);
	
		
		lp.LginCredentials("tata", "Smarti@321");

		
	}
    
    // smoke , regression , functional , negative

    
    @Test(groups="smoke")
    public void TS0017() throws InterruptedException
    {
    	organizationPage.VerifyNewOrganizationPage();
    }

    @Test(groups={"regression , functional"})
    public void TS0018() throws InterruptedException 
    {
    	// public void AddOrganization(String Org, String OrgName, String OrgCode, String Location, String Address, String EmailId, String ContactNo, 
        //String StartDate, String EndDate, String EmployeeStrength, String TypeofService, String AuditRemark)
        organizationPage.AddOrganization("OEM","Meclix", "WHO-10","Kalyan","Bhumi World", "priyapendu", "1234567889","02-16-2025", "01-16-2026", "15", "Cleaning", "Verified");  
    
     }
    
    @Test(groups="regression")
    public void TS0019() throws InterruptedException
    {
        organizationPage.viewOrg("Meclix");
    }
    
     @Test(groups={"regression , functional"}) 
    public void TS0020() throws InterruptedException
    {
    	 //public void EditOrganization(String ORG, String NewORGType, String NewORGName, String NewORGCode, String NewLocation, 
		//String NewAdd, String NewEmail, String Contact, String NStartD, String NEndD, String EmployeeS, String TypeofS, String NAudit)
    	organizationPage.EditOrganization("test", "Partner", "NewTest", "NewCode", "London", "Bhiwandi", "testemail",
    										"565656656", "18/10/2025", "18/12/2025", "20", "NewTest", "TestAuditRemark");
    }
    
    @Test(groups={"regression , functional"})
    public void TS0022() throws InterruptedException
    {
    	organizationPage.ExportToExcel();
    }

    @Test(groups={"regression , functional"})
    public void TS0023() throws InterruptedException
    {
    	organizationPage.PdfExport();
    }
    
    
    @Test(groups="smoke")
    public void TS0024() throws InterruptedException
    {
    	organizationPage.SearchBar("Meclix", "342");
    }
    
    @Test(groups={"regression , functional"})
    public void TS0025() throws InterruptedException
    {
    	organizationPage.LocationFilter("Mumbai");
    }
    
   @Test(groups={"regression , functional, negative"})
    public void TS0026() throws InterruptedException
    {
    	organizationPage.CheckOrgINDiffComp();
    }
    
    @Test(groups="regression")
	public void TS0027() throws InterruptedException 
    {
		organizationPage.MandatorySign();
	}
    
    @Test(groups="smoke")
    public void TS0028() throws InterruptedException
    {
    	organizationPage.VerifyNOrgTypeForm();
    }
    
 
}
