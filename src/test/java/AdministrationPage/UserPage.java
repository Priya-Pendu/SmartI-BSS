package AdministrationPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;
import Utilities.ReadData;

public class UserPage extends BasePage {

	public UserPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
		@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
		@FindBy(xpath="//span[normalize-space()='Administration']") WebElement Administration;
		@FindBy(xpath="//span[normalize-space()='User']") WebElement User;
		@FindBy(xpath="//span[normalize-space()='New User']") WebElement NewUser;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_Username']") WebElement Username;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_DisplayName']") WebElement DisplayName;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_Email']") WebElement Email;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_Password']") WebElement Password;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_PasswordConfirm']") WebElement ConfirmPassword;
		@FindBy(xpath="//span[normalize-space()='Save']") WebElement SaveButton;
		@FindBy(xpath="//input[@class='emaildomain']") WebElement EmailDomain;
		@FindBy(xpath="//input[@type=\"file\"]") WebElement SelectFile;
		@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Administration_UserDialog8_CustomerID']//b[@role='presentation']") WebElement CustomerDrop;
		@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable select2-highlighted\"]") List<WebElement> CustomerOption;
		@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Administration_UserDialog8_CompanyMasterId']//span[@role='presentation']") WebElement CompanyDrop;
		@FindBy(xpath="//ul[@id='select2-results-2']/*") List<WebElement> CompanyOption;
		@FindBy(xpath="//a[normalize-space()='Misc']") WebElement MiscOption;
		@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_UserDialog8_PasswordExpiryInDays']") WebElement PassExpiryDays;
		@FindBy(xpath = "//input[@id='BuildingSolutionSuite_Administration_UserDialog8_LoginType']") WebElement LoginTypeInput;
		@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement SearchBar;
		@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]/a") WebElement SearchedUserResult;
		@FindBy(xpath="//input[@name=\"Username\"]") WebElement EditUsername;
		@FindBy(xpath="//input[@name=\"DisplayName\"]") WebElement EditDisplayName;
		@FindBy(xpath="//input[@name=\"Email\"]") WebElement EditEmail;
		@FindBy(xpath="//input[@class='emaildomain']") WebElement EditEmailDomain;
		@FindBy(xpath="//span[@class=\"select2-chosen\"]") WebElement EditCustomer;
		@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Administration_UserDialog8_CompanyMasterId']//a[@class='select2-choice select2-default']") WebElement EditCompany;
		@FindBy(xpath="//input[@class=\"editor s-Serenity-IntegerEditor s-IntegerEditor integerQ\"]") WebElement EditPassExpiryDays;
		@FindBy(xpath = "//input[@class=\"editor s-Serenity-DateEditor s-DateEditor hasDatepicker customValidate readonly\"]") WebElement EditPassExpiryDate;
		@FindBy(xpath="//span[normalize-space()='Delete']") WebElement DeleteButton;
		@FindBy(xpath="//button[normalize-space()='Yes']") WebElement YesButton;
		
		DropDownMethod DD = new DropDownMethod();
		ReadData RD = new ReadData();
		
		////div[@class='tool-button add-file-button fileinput-button']
        //Action Method
		
		
		public void InitialStep()
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Access']"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Administration']"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='User']"))).click();
		}
		
		//TS0194 - Create a new user
		public void AddUser(String User, String DisplayN, String Mail, String EmailDomainData,String Pass) throws InterruptedException 
		{

			logger.info("STEP 1: Initial step started");
			InitialStep();
			
			logger.info("STEP 2: Clicking New User button");
			wait.until(ExpectedConditions.elementToBeClickable(NewUser)).click();
			
			logger.info("STEP 3: Entering Username");
			wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(User);
			
			logger.info("STEP 4: Entering Display Name");
			DisplayName.sendKeys(DisplayN);

			logger.info("STEP 5: Entering Email");
			Email.sendKeys(Mail);

			logger.info("STEP 6: Entering Email Domain");
			EmailDomain.sendKeys(EmailDomainData);

			logger.info("STEP 7: Uploading profile image");
			SelectFile.sendKeys("D:\\Users\\Priya\\Pictures\\Profile_Icon.png");

			logger.info("STEP 8: Entering Password");
			wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(Pass);

			logger.info("STEP 9: Confirming Password");
			ConfirmPassword.sendKeys(Pass);

			logger.info("STEP 10: Clicking Customer dropdown");
			wait.until(ExpectedConditions.elementToBeClickable(CustomerDrop)).click();

			logger.info("STEP 11: Selecting Customer = Paytm");
			DD.selectFromDropdown(CustomerOption, "Paytm", "Customer");

			logger.info("STEP 12: Clicking Company dropdown");
			wait.until(ExpectedConditions.elementToBeClickable(CompanyDrop)).click();

			logger.info("STEP 11: Selecting Company = tata");
			DD.selectFromDropdown(CompanyOption, "tata", "Company");
			
			logger.info("STEP 13: Clicking Save button");
			wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
			Thread.sleep(10000);
			logger.info("STEP 14: User created successfully");
			
			Assert.assertTrue(NewUser.isDisplayed(), "User creation failed");
		}
		
		
		//TS0195 - Create a new user with misc option
		public void CreateNUserWithMiscOption(String User, String DisplayN, String Mail, String EmailDomainData,String Pass, String PassDate, String LoginType) throws InterruptedException {

			logger.info("STEP 1: Initial step started");
			InitialStep();
			
			logger.info("STEP 2: Clicking New User button");
			wait.until(ExpectedConditions.elementToBeClickable(NewUser)).click();
			
			logger.info("STEP 3: Entering Username");
			wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(User);
			
			logger.info("STEP 4: Entering Display Name");
			DisplayName.sendKeys(DisplayN);

			logger.info("STEP 5: Entering Email");
			Email.sendKeys(Mail);

			logger.info("STEP 6: Entering Email Domain");
			EmailDomain.sendKeys(EmailDomainData);

			logger.info("STEP 7: Uploading profile image");
			SelectFile.sendKeys("D:\\Users\\Priya\\Pictures\\Profile_Icon.png");

			logger.info("STEP 8: Entering Password");
			wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(Pass);

			logger.info("STEP 9: Confirming Password");
			ConfirmPassword.sendKeys(Pass);

			logger.info("STEP 10: Clicking Customer dropdown");
			wait.until(ExpectedConditions.elementToBeClickable(CustomerDrop)).click();

			logger.info("STEP 11: Selecting Customer = Paytm");
			DD.selectFromDropdown(CustomerOption, "Paytm", "Customer");

			logger.info("STEP 12: Clicking Company dropdown");
			wait.until(ExpectedConditions.elementToBeClickable(CompanyDrop)).click();

			logger.info("STEP 13: Selecting Company = tata");
			DD.selectFromDropdown(CompanyOption, "tata", "Company");

			logger.info("STEP 14: Clicking on 'Misc' option");
			wait.until(ExpectedConditions.elementToBeClickable(MiscOption)).click();
			
			logger.info("STEP 15: Entering Password Expiry Days");
			wait.until(ExpectedConditions.visibilityOf(PassExpiryDays)).sendKeys(PassDate);
			
			logger.info("STEP 16: Entering login type");
			wait.until(ExpectedConditions.visibilityOf(LoginTypeInput)).sendKeys(LoginType);
			
			logger.info("STEP 13: Clicking Save button");
			wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
			Thread.sleep(10000);
			logger.info("STEP 14: User created successfully");
			
			Assert.assertTrue(NewUser.isDisplayed(), "User creation failed");
		}
		
		//TS0196 - View  user Form
		public void ViewUserForm(String User) throws InterruptedException {

		    logger.info("STEP 1: Initial step started");
		    InitialStep();

		    logger.info("STEP 2: Sending text on search bar");
		    wait.until(ExpectedConditions.visibilityOf(SearchBar)).sendKeys(User);

		    Thread.sleep(2000);
		    logger.info("STEP 3: Clicking searched User");
		    wait.until(ExpectedConditions.visibilityOf(SearchedUserResult));

		    String searchedUserName = SearchedUserResult.getText().trim();
		    logger.info("Actual searched user from UI: [" + searchedUserName + "]");
		    logger.info("Expected user: [" + User + "]");

		    SearchedUserResult.click();
		    logger.info("STEP 5: User form opened successfully");

		    // ----- STEP 6: Read values safely -----
		    String username        = RD.readValue(Username);
		    String displayName     = RD.readValue(DisplayName);
		    String email           = RD.readValue(Email);
		    String emailDomain     = RD.readValue(EmailDomain);
		    String customer        = RD.readText(EditCustomer);
		    String company         = RD.readText(EditCompany);

		    logger.info(
		        "STEP 6: getting all information of user form | " +
		        "Username=" + username + " | " +
		        "DisplayName=" + displayName + " | " +
		        "Email=" + email + " | " +
		        "EmailDomain=" + emailDomain + " | " +
		        "Customer=" + customer + " | " +
		        "Company=" + company
		    );

		    logger.info("STEP 6: Clicking on 'Misc' option");
		    wait.until(ExpectedConditions.elementToBeClickable(MiscOption)).click();
		    
		    // ----- STEP 7 -----
		    logger.info(
		        "STEP 7: getting all information from misc option tab | " +
		        "PassExpiryDays=" + RD.readValue(EditPassExpiryDays) + " | " +
		        "PassExpiryDate=" + RD.readValue(EditPassExpiryDate)
		    );
		}

		//TS0197 - Update  user Form
		public void updateUserForm(String User, String UpdatedUsername, String UpdatedDisplayname, String UpdatedUserMail, String UpdatedDomain, String UpdatedPass, String ConfirmPass) throws InterruptedException
		{
		    logger.info("STEP 1: Initial step started");
		    InitialStep();
		    
		    logger.info("STEP 2: Sending text on search bar");
		    wait.until(ExpectedConditions.visibilityOf(SearchBar)).sendKeys(User);

		    Thread.sleep(2000);
		    logger.info("STEP 3: Clicking searched User");
		    wait.until(ExpectedConditions.visibilityOf(SearchedUserResult));

		    String searchedUserName = SearchedUserResult.getText().trim();
		    logger.info("Actual searched user from UI: [" + searchedUserName + "]");
		    logger.info("Expected user: [" + User + "]");

		    SearchedUserResult.click();
		    logger.info("STEP 5: User form opened successfully");
		   
		    logger.info("STEP 6: updating Username");
		    wait.until(ExpectedConditions.visibilityOf(EditUsername)).clear();
		    EditUsername.sendKeys(UpdatedUsername);
		    
		    logger.info("STEP 7: updating Display Name");
		    wait.until(ExpectedConditions.visibilityOf(EditDisplayName)).clear();
		    EditDisplayName.sendKeys( UpdatedDisplayname);
		    
		    logger.info("STEP 8: updating email");
		    wait.until(ExpectedConditions.visibilityOf(EditEmail)).clear();
		    EditEmail.sendKeys(UpdatedUserMail);
		    
		    logger.info("STEP 9: updating email domain");
		    wait.until(ExpectedConditions.visibilityOf(EditEmailDomain)).clear();
		    EditEmailDomain.sendKeys(UpdatedDomain);
		    
		    logger.info("STEP 9: updating password");
		    wait.until(ExpectedConditions.visibilityOf(Password)).clear();
		    Password.sendKeys(UpdatedPass);

		    logger.info("STEP 10: confirming updated password");
		    wait.until(ExpectedConditions.visibilityOf(ConfirmPassword)).clear();
		    ConfirmPassword.sendKeys(ConfirmPass);
		    
		    logger.info("STEP 11: Clicking save button");
		    wait.until(ExpectedConditions.visibilityOf(SaveButton)).click();
		    
		    Thread.sleep(2000);
		    logger.info("STEP 12: Reopening the updated user form to verify changes ");
		    wait.until(ExpectedConditions.visibilityOf(SearchBar)).clear();
		    SearchBar.sendKeys(UpdatedUsername);

		    Thread.sleep(2000);
		    logger.info("STEP 13: Clicking searched User");
		    wait.until(ExpectedConditions.visibilityOf(SearchedUserResult));

		    String searchupdatedname = SearchedUserResult.getText().trim();
		    logger.info("Actual searched user from UI: [" + searchupdatedname + "]");
		    logger.info("Expected user: [" + User + "]");

		    SearchedUserResult.click();
		    logger.info("STEP 5: User form opened successfully");
		    
		    Assert.assertEquals(RD.readValue(EditUsername), UpdatedUsername, "Username update failed");
		    Assert.assertEquals(RD.readValue(EditDisplayName), UpdatedDisplayname, "Display Name update failed");
		    Assert.assertEquals(RD.readValue(EditEmail),  UpdatedUserMail, "Email update failed");
		    
		    logger.info("STEP 14: User details updated successfully");
		    
		}
		
		//TS0198 - Delete user
		public void DeleteUser(String User) throws InterruptedException
		{
			 logger.info("STEP 1: Initial step started");
			    InitialStep();
			    
			    logger.info("STEP 2: Sending text on search bar");
			    wait.until(ExpectedConditions.visibilityOf(SearchBar)).sendKeys(User);

			    Thread.sleep(2000);
			    logger.info("STEP 3: Clicking searched User");
			    wait.until(ExpectedConditions.visibilityOf(SearchedUserResult));

			    String searchedUserName = SearchedUserResult.getText().trim();
			    logger.info("Actual searched user from UI: [" + searchedUserName + "]");
			    logger.info("Expected user: [" + User + "]");

			    SearchedUserResult.click();
			    logger.info("STEP 5: User form opened successfully");
			    
			    logger.info("STEP 6: Clicking Delete button");
			    wait.until(ExpectedConditions.elementToBeClickable(DeleteButton)).click();
			    
			    logger.info("STEP 7: Confirming delete action");
			    wait.until(ExpectedConditions.elementToBeClickable(YesButton)).click();
			    
			    Thread.sleep(2000);
			    logger.info("STEP 3: Clicking searched User");
			    wait.until(ExpectedConditions.visibilityOf(SearchedUserResult));
			    
			    Assert.assertFalse(SearchedUserResult.isDisplayed(), "User deletion failed");
			    
		}
}
