package MasterPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;



public class CityPage extends BasePage
{
	WebDriver driver ;
	//constructor
	public CityPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//i[@class='nav-icon fa fa-th-list']") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='City']") WebElement City;
	@FindBy(xpath="//span[normalize-space()='New City Master']") WebElement NewCity;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_CityMasterDialog10_CityName']") WebElement CityName;
	@FindBy(xpath ="//div[@id='s2id_BuildingSolutionSuite_Master_CityMasterDialog10_CountryId']//b[@role='presentation']") WebElement CountryDrop;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_CityMasterDialog10_StateId']//b[@role='presentation']") WebElement StateDrop;
	@FindBy(xpath="//input[@id='s2id_autogen2_search']") WebElement SearchCountry;
	@FindBy(xpath="//input[@id='s2id_autogen3_search']") WebElement SearchState;
	@FindBy(xpath="//ul[@id='select2-results-2']/*")List <WebElement> CountryOptions;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*") List <WebElement> StateOptions; 
	@FindBy(xpath="//div[@tabindex='-1'][@role='dialog'][@aria-labelledby='ui-id-1']") WebElement CityDialoageBox;
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement Savebtn;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement Ok;
	@FindBy(xpath="//button[@title='Close']")
	WebElement close;
	//Edit city locators
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement EditSearchCity;
	@FindBy(xpath="//div[@class='slick-cell l2 r2']/a")
	WebElement EditSelectCity;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Master-CityMasterDialog s-Master-CityMasterDialog s-CityMasterDialog ui-draggable ui-resizable flex-layout']")
	WebElement EditCityBox;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_CityMasterDialog10_CityName']")
	WebElement EditCityN;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement saveapply;
	@FindBy(xpath="//button[@title='Close']")
	WebElement EditClose;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_CityMasterDialog10_CityName']")
	WebElement CityField;
	@FindBy(xpath="//span[@id='select2-chosen-2']")
	WebElement CountryField;
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	WebElement StateField;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_CityMasterDialog10_CountryId']//b[@role='presentation']")
	WebElement CountryDropbtn;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_CityMasterDialog10_StateId']//b[@role='presentation']")
	WebElement StateDropbtn;
	@FindBy(xpath="//a[@class='dropdown-toggle']") WebElement Profile;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement Logout;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement Username;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Password;
	@FindBy(xpath="//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement LoginBtn;
	@FindBy(xpath="//b[@role='presentation']") WebElement CountryFilterDrop;
	@FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]") WebElement FilterCountryResult;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']") WebElement SearchCountryFilter;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]") List<WebElement> FilterCountryOption;
	DropDownMethod dd = new DropDownMethod();
	
	//ActionMethods
	public void InitialStep()
	{
		AccessManagment.click();
		Master.click();
		City.click();
	}
	//TS0081 - Create a new City
	public void VerifyCityPg()
	{
		InitialStep();
		NewCity.click();
		wait.until(ExpectedConditions.visibilityOf(CityDialoageBox));
		if (CityField.getText().isEmpty()&& CountryField.getText().contains("select") && StateField.getText().contains("select")) {
			System.out.println("New City Page is displayed blank");
			Assert.assertTrue(true);
		} else {
			System.out.println("New City Page is not displayed");
			Assert.assertTrue(false);
		}
	}
	
	//TS0082 - Add New City
	public void AddCity(String CityN, String Country, String State) throws InterruptedException
	{
		InitialStep();
		NewCity.click();
		
		wait.until(ExpectedConditions.visibilityOf(CityDialoageBox));
		
		CityName.sendKeys(CityN);
		CountryDrop.click();
		SearchCountry.sendKeys(Country);
		
		for(WebElement SelectCountry : CountryOptions)
		{
			if(SelectCountry.getText().trim() .equals(Country))
			{
				SelectCountry.click();
				break;
			}
		}
		
		StateDrop.click();
		SearchState.sendKeys(State);
		
		for(WebElement SelectState : StateOptions )
		{
			if(SelectState.getText().trim().equals(State))
			{
				SelectState.click();
				break;
			}
		}
		
		Savebtn.click();
		
	}
	

	//TS0083 - View Existing City
	public void ViewCity(String City) {
		InitialStep();
		EditSearchCity.sendKeys(City);

		if (EditSelectCity.getText().equals(City)) {
			EditSelectCity.click();
			System.out.println("Details of the City is : " + EditCityN.getAttribute("value") + ","
					+ CountryField.getText() + "," + StateField.getText());
			close.click();
		} else {
			System.out.println("City dose not match");
		}
	}
	
	//TS0084 - Edit Existing City
	public void EditState(String City,String NewCityN ) throws InterruptedException
		{
		    InitialStep();
			EditSearchCity.sendKeys(City);
			
			if(EditSelectCity.getText().equals(City))
			{
				EditSelectCity.click();
			}
			else
			{
				System.out.println("City dose not match");
			}
			EditCityN.clear();
			EditCityN.sendKeys(NewCityN);
			CountryDropbtn.click();
			dd.selectFromDropdown(CountryOptions, "Indonesia", "Country");
			StateDropbtn.click();
			Thread.sleep(2000);
			dd.selectFromDropdown(StateOptions, "AIO", "State");
			saveapply.click();
			EditClose.click();
		}
		
	//TS0086  - Search City by Name
	public void VerifySearch(String CityN)
	{
		InitialStep();
		EditSearchCity.sendKeys(CityN);
		if (EditSelectCity.getText().equals(CityN)) {
			System.out.println("City found in search");
		} else {
			System.out.println("City not found in search");
		}
	}
	
	//TS0087 - Check whether city added in one company admin should not get reflected in other company admin
	public void VerifyAccrossCompanies(String CityN) throws InterruptedException
	{
		InitialStep();
		EditSearchCity.sendKeys(CityN);
		Thread.sleep(2000);
		Assert.assertTrue(EditSelectCity.getText().equals(CityN), "City found in search");
		Profile.click();
		Logout.click();
		Username.sendKeys("enviro");
		Password.sendKeys("Smarti@123");
		LoginBtn.click();
		InitialStep();
		EditSearchCity.sendKeys(CityN);
		Thread.sleep(2000);
		Assert.assertFalse(EditSelectCity.getText().equals(CityN), "City found in search in other company");
	}
	
	//TS0088 - check based on country filter selection wise city data gets filtered or not
	public void verifyCountryFilter(String country) {
	    InitialStep();
	    CountryFilterDrop.click();
	    SearchCountryFilter.sendKeys(country);

	    for (WebElement option : FilterCountryOption) {
	        if (option.getText().trim().equalsIgnoreCase(country)) {
	            option.click();
	            break;
	        }
	    }

	    // Replace Thread.sleep() with explicit waits if possible
	    wait.until(ExpectedConditions.textToBePresentInElement(FilterCountryResult, country));

	    boolean isFiltered = FilterCountryResult.getText().contains(country);
	    Assert.assertTrue(isFiltered, "City not filtered based on country selection");
	    System.out.println(isFiltered ? "City filtered based on country selection"
	                                  : "City not filtered based on country selection");
	}

}	
