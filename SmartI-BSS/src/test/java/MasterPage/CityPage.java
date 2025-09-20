package MasterPage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObject.BasePage;

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
	@FindBy(xpath="//div[contains(@class,'row')]//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]") WebElement AccessManagment;
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
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_CityMasterDialog17_CityName']")
	WebElement EditCityN;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement saveapply;
	@FindBy(xpath="//button[@title='Close']")
	WebElement EditClose;
	
	//ActionMethods
	
	public void AddCity(String CityN, String Country, String State) throws InterruptedException
	{
		AccessManagment.click();
		Master.click();
		City.click();
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
		System.out.println(Alert.getText());
		Ok.click();
		close.click();
	}
	
	
	public void EditState(String City,String NewCityN )

		{
			EditSearchCity.sendKeys(City);
			
			if(EditSelectCity.getText().equals(City))
			{
				EditSelectCity.click();
			}
			else
			{
				System.out.println("City dose not match");
			}
			
			EditCityN.sendKeys(NewCityN);
			saveapply.click();
			EditClose.click();
		}
		
	
}	
