package AdministrationTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AdministrationPage.UserPage;
import LoginTest.LoginPage;
import Utilities.BaseTest;

public class UserTest extends BaseTest {

	UserPage UP;
	LoginPage lp;
	
	@BeforeMethod (alwaysRun = true)
	public void Login()
	{
		UP = new UserPage(driver);
		
		
		lp = new LoginPage(driver);
		
		lp.LginCredentials("tata", "Smarti@321");
	}

	// smoke , regression , functional , negative
	
	@Test(groups ={"regression" , "functional"})
	public void TS0194() throws InterruptedException
	{
		//String User, String DisplayN, String Mail, String EmailDomainData,String Pass
		UP.AddUser("UserTest", "UserTest", "testmail", "gmail.com", "Smarti@12345");
	}
	
	@Test(groups ={"regression" , "functional"})
	public void TS0195() throws InterruptedException
	{
		
	    UP.CreateNUserWithMiscOption("TestUser", "TestUser", "testusermail", "gmail.com" , "Smarti@12345", "365", "Security");
	}
	
	@Test(groups ="regression")
	public void TS0196() throws InterruptedException
	{
		UP.ViewUserForm("Infosys");
	}
	
	@Test(groups = {"functional","regression"})
	public void TS0197() throws InterruptedException {
		
		UP.updateUserForm("UpdatedUser", "UpdatedUserN","UpdatedDispN" ,"updatemail", "gmail.com", "Smarti@54312", "Smarti@54312");
	}
	
	@Test(groups ={"functional","regression"})
	public void TS0198() throws InterruptedException {

		UP.DeleteUser("adf");
	}
	
}
