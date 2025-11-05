package MasterPage;




import java.time.Duration;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;




public class StatePage extends BasePage
{


	//constructor
	public StatePage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locator
	@FindBy(xpath="//p[contains(@class,'title-text')][contains(text(),'Access')]") WebElement AccessManagement;
	@FindBy(xpath="//i[@class='nav-icon fa fa-th-list']") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='State']") WebElement State;
	@FindBy(xpath="//span[normalize-space()='New State Master']") WebElement NewState;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_StateMasterDialog8_StateName']") WebElement StateN;
	@FindBy(xpath="//b[@role='presentation']") WebElement CountryDrop;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']") WebElement CountrySearch;
	@FindBy(xpath ="//ul[@id='select2-results-1']/*") List<WebElement> CountryOptions;
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement Savebtn;
	@FindBy(xpath="//div[@tabindex='-1'][@role='dialog'][@aria-labelledby='ui-id-1']") WebElement DialoageBox;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//i[@class='fa fa-times']") WebElement Close;
	//Edit State 
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement EditSearchState;
    @FindBy(xpath="//div[@class='slick-cell l1 r1']/a") WebElement EditStateName;
    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Master-StateMasterDialog s-Master-StateMasterDialog s-StateMasterDialog ui-draggable ui-resizable flex-layout']")
    WebElement EditDialogBox;
    @FindBy(xpath="//button[normalize-space()='OK']")
    WebElement Ok;
    @FindBy(name="StateName") 
    WebElement EditStateN;
    @FindBy(xpath="//b[@role='presentation']")
    WebElement EditCountyDrop;
    @FindBy(id="s2id_autogen1_search") 
    WebElement EditCountrySearch;
    @FindBy(xpath="//ul[@class=\"select2-results\"]/*")
    List <WebElement> CountryList;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement saveapply;
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement close;
	@FindBy(xpath="//span[@id='ui-id-2']")
	WebElement EditStateTitle;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_StateMasterDialog8_StateName']")
	WebElement Statefield;
	@FindBy(xpath="//span[@id='select2-chosen-1']")
	WebElement Countryfield;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement Profile;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement Username;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Password;
	@FindBy(xpath="//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement LoginBtn;
	DropDownMethod DM = new DropDownMethod();
	

	
	//ActionMethod
	public void InitialStep() {
		AccessManagement.click();
		Master.click();
		State.click();
	}
	
	//TS0073 - Create a new State
	public void VerifyNewStatePage() throws InterruptedException {
		InitialStep();
		NewState.click();
		wait.until(ExpectedConditions.visibilityOf(DialoageBox));
		if (Statefield.getText().equals("") && Countryfield.getText().contains("select") ) {
			System.out.println("New State dialog box is displayed");
		}
	}
	
	//TS0074 - Fill State Details
	public void AddState(String StateName, String CountryName) throws InterruptedException
	{
		InitialStep();
		NewState.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DialoageBox));	
		StateN.sendKeys(StateName);
		CountryDrop.click();
		CountrySearch.sendKeys(CountryName);
	
		for(WebElement Country : CountryOptions)
		{
			if(Country.getText().trim().equals(CountryName))
			{
				Country.click();
				break;
			}
		}
		Thread.sleep(3000);
		Savebtn.click();
		Thread.sleep(3000);
		EditSearchState.sendKeys(StateName);
		Assert.assertTrue(EditStateName.isDisplayed(), "New State dialog box is not closed");
	}
	
	//TS0075 - View an existing State
	public void ViewState(String StateName) throws InterruptedException {
		InitialStep();
		EditSearchState.sendKeys(StateName);
		Thread.sleep(2000);
		if(EditStateName.getText().equals(StateName))
		{
			EditStateName.click();
			System.out.println("Details of the state is : " +EditStateN.getAttribute("value")+"," +Countryfield.getText());
			close.click();
		}
		Assert.assertTrue(NewState.isDisplayed(), "State details dialog box is not closed");
	}
	
	//TS0076 - Edit an existing State
	public void EditState(String EnterStateN, String NewStateN ) throws InterruptedException
	{
		InitialStep();
		EditSearchState.sendKeys(EnterStateN);
		if(EditStateName.getText().equals(EnterStateN))
		{
			EditStateName.click();
			EditStateN.clear();
			EditStateN.sendKeys(NewStateN);
			EditCountyDrop.click();
			DM.selectFromDropdown(CountryList, "Indonesia", "Country");
			saveapply.click();
			Thread.sleep(2000);
			close.click();
		}
		Assert.assertTrue(NewState.isDisplayed(), "State not edited successfully");
	}
	 
	//TS0077 - Search State
	public void VerifySearch(String StateName) throws InterruptedException
	{
		InitialStep();
		EditSearchState.sendKeys(StateName);
		Thread.sleep(2000);
		Assert.assertTrue(EditStateName.getText().equals(StateName), "Search functionality is not working");
	}
	
	public void CheckStateAccrosCompanies(String StateName) throws InterruptedException
	{
		VerifySearch(StateName);
		Profile.click();
		Logout.click();
		Username.sendKeys("enviro");
		Password.sendKeys("Smarti@123");
		LoginBtn.click();
		InitialStep();
		EditSearchState.sendKeys(StateName);
		Thread.sleep(2000);
		Assert.assertFalse(EditStateName.getText().equals(StateName), "Search functionality is not working");
		
	}
}
