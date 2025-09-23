package MasterTest;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        driver.get("http://localhost:170/"); 
        driver.manage().window().maximize();  
        organizationPage = new OrganizationPage(driver);
    }

    @Test(priority=1)
    public void AddOrganization() throws InterruptedException 
    {
    	LoginPage lp = new LoginPage(driver);
	    lp.LginCredentials("Crisil", "Smarti@123");
        organizationPage.AddOrganization("OEM","WHO", "WHO-01","Kalyan","Bhumi World", "priyapendu", "1234567889","01/16/2025", "01/16/2026", "15", "Cleaning", "Verified");  
    
     }
    
    @Test(priority=2)
    public void EditOrganizationDetails() throws InterruptedException
    {
    	organizationPage.EditOrganization("test", "Partner", "NewTest", "NewCode", "London", "Bhiwandi", "testemail", "565656656", "06/02/2025", "07/02/2025", "20", "NewTest");
    }
    	

    @AfterTest
    public void tearDown() {
        // Close the browser after tests are done
        driver.quit();
    }
}
