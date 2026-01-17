package MasterTest;


import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LoginTest.LoginPage;
import MasterPage.DivisionPage;
import Utilities.BaseTest;

public class DivisionTest extends BaseTest {

    
     DivisionPage DP;
     LoginPage lp;

    @BeforeMethod (alwaysRun = true)
    public void Login() {

    	System.out.println("INIT PAGES CALLED");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);

        DP = new DivisionPage(driver);

        lp = new LoginPage(driver);
       
        lp.LginCredentials("tata", "Smarti@321");
    }

    @Test(groups = "smoke")
    public void TS0030() throws InterruptedException {
    	System.out.println("TEST CLASS = " + this.getClass().getName());
        DP.VerifyNewDivisionPage();
    }

    @Test(groups = {"regression", "functional"})
    public void TS0031() throws InterruptedException {
        DP.AddDivision("Kalyan", "New-Divi05", "R&D05", "Testing Purpose");
    }

    @Test(groups = "regression")
    public void TS0032() throws InterruptedException {
        DP.ViewExistDivi("Marketing");
    }

    @Test(groups = {"regression", "functional"})
    public void TS0033() throws InterruptedException {
        DP.EditDivision("Software-01", "Mumbai", "New-Divi02", "Software-01");
    }

    @Test(groups = {"regression", "functional"})
    public void TS0034() throws InterruptedException {
        DP.ExportExcel();
    }

    @Test(groups = {"regression", "functional"})
    public void TS0035() throws InterruptedException {
        DP.ExportPDF();
    }

    @Test(groups = "smoke")
    public void TS0036() throws InterruptedException {
        DP.VerifySearchBar("Division C", "Divi-B");
    }

   
}
