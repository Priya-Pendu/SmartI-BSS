package MasterTest;
import java.time.Duration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.OrganizationPage;

public class OrganizationTest {

    WebDriver driver;
    OrganizationPage organizationPage;
    

    @BeforeTest
    public void setup() {
       
        //System.setProperty("webdriver.chrome.driver", "D:\\Priya\\chromedriver-win64\\chromedriver.exe"); // Ensure this is correct
    	// Set Chrome preferences for download
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "D:\\Priya\\BSS_Automation_Files\\Eclipse-Workspace\\SmartISystems-BSS\\SmartI-BSS\\SmartI-BSS\\download");
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("plugins.always_open_pdf_externally", true); // auto-download PDFs

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs); 
        
        driver = new ChromeDriver(options); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        driver.get("http://localhost:915/"); 
        driver.manage().window().maximize();  
        organizationPage = new OrganizationPage(driver);
        LoginPage lp = new LoginPage(driver);
	    lp.LginCredentials("tata", "Smarti@321");
    }
    
    //@Test(priority=0)
    public void TS0017() throws InterruptedException
    {
    	organizationPage.VerifyNewOrganizationPage();
    }

    //@Test(priority=1)
    public void TS0018() throws InterruptedException 
    {
    	// public void AddOrganization(String Org, String OrgName, String OrgCode, String Location, String Address, String EmailId, String ContactNo, 
        //String StartDate, String EndDate, String EmployeeStrength, String TypeofService, String AuditRemark)
        organizationPage.AddOrganization("OEM","Meclix", "WHO-10","Kalyan","Bhumi World", "priyapendu", "1234567889","02-16-2025", "01-16-2026", "15", "Cleaning", "Verified");  
    
     }
    
    //@Test(priority=2)
    public void TS0019() throws InterruptedException
    {
        organizationPage.viewOrg("Meclix");
    }
    
     //@Test(priority=3) 
    public void TS0020() throws InterruptedException
    {
    	 //public void EditOrganization(String ORG, String NewORGType, String NewORGName, String NewORGCode, String NewLocation, 
		//String NewAdd, String NewEmail, String Contact, String NStartD, String NEndD, String EmployeeS, String TypeofS, String NAudit)
    	organizationPage.EditOrganization("test", "Partner", "NewTest", "NewCode", "London", "Bhiwandi", "testemail",
    										"565656656", "18/10/2025", "18/12/2025", "20", "NewTest", "TestAuditRemark");
    }
    
    //@Test(priority=4)
    public void TS0022() throws InterruptedException
    {
    	organizationPage.ExportToExcel();
    }

    //@Test(priority=5)
    public void TS0023() throws InterruptedException
    {
    	organizationPage.PdfExport();
    }
    
    
    //@Test(priority=6)
    public void TS0024() throws InterruptedException
    {
    	organizationPage.SearchBar("Meclix", "342");
    }
    
    @Test(priority=7)
    public void TS0025() throws InterruptedException
    {
    	organizationPage.LocationFilter("Mumbai");
    }
    
   // @Test(priority=8)
    public void TS0026() throws InterruptedException
    {
    	organizationPage.CheckOrgINDiffComp();
    }
    
    //@Test(priority=9)
	public void TS0027() throws InterruptedException 
    {
		organizationPage.MandatorySign();
	}
    
    //@Test(priority=10)
    public void TS0028() throws InterruptedException
    {
    	organizationPage.VerifyNOrgTypeForm();
    }
    
    @AfterTest
    public void tearDown() {
        // Close the browser after tests are done
        driver.quit();
    }
}
