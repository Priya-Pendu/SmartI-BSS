package MasterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginTest.LoginPage;
import MasterPage.UserPageObject;
import Utilities.BaseTest;


public class UserTest extends BaseTest 
{
	UserPageObject UP;
	LoginPage lp;
	
	@BeforeMethod(alwaysRun = true)
	public void Setup()
	{

		UP = new UserPageObject(driver);

		lp = new LoginPage(driver);
	
		lp.LginCredentials("tata", "Smarti@321");

		
	}
	
	// smoke , regression , functional , negative
	
	@Test(groups={"regression , functional"})
	public void AddUser() throws InterruptedException
	{
		UP.AddUser("Test", "Priya", "priyapendu", "Priya@12345");
	}
	
	@Test(groups={"regression , functional"})
	public void UpdateUser() throws InterruptedException
	{
		UP.EditUser("Test", "Test1", "Test1", "50");
	}
	

	

}
