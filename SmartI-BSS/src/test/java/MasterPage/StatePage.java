package MasterPage;




import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.BasePage;


public class StatePage extends BasePage
{

	WebDriver driver ;
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
    List <WebElement> EditCountryDrop;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement saveapply;
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement close;
	
	
	
	
	//ActionMethod
	
	public void AddState(String StateName, String CountryName) throws InterruptedException
	{
		AccessManagement.click();
		Master.click();
		State.click();
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
		
		System.out.println(Alert.getText());
		Ok.click();
		Close.click();
	}
	
	public void EditState(String EnterStateN, String NewStateN, String NewCountry) throws InterruptedException
	{
		EditSearchState.sendKeys(EnterStateN);
		
		if(EditStateName.getText().equals(EnterStateN))
		{
			EditStateName.click();
		}
		else
		{
			System.out.println("State name dose not match");
		}
		
		//System.out.println(EditDialogBox.getText());;
		Thread.sleep(3000);
		EditStateN.clear();
		EditStateN.sendKeys(NewStateN);
		/*
		EditCountyDrop.click();
		EditCountrySearch.sendKeys(NewCountry);
		
		for(WebElement SelectCountry : EditCountryDrop)
		{
			if(SelectCountry.getText().trim().equals(NewCountry))
			{
				SelectCountry.click();
				break;
			}
		}*/
		
		saveapply.click();
		close.click();
	}
	/*
	public void EditState(String EnterStateN, String NewStateN, String NewCountry) throws InterruptedException {
	    EditSearchState.sendKeys(EnterStateN);

	    if (EditStateName.getText().equals(EnterStateN)) {
	        EditStateName.click();
	    } else {
	        System.out.println("State name does not match");
	    }

	    Thread.sleep(3000);
	    
	    // Explicit wait for the input field to be clickable
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(EditStateN));
	    
	    EditStateN.clear();
	    EditStateN.sendKeys(NewStateN);

	    // Wait for the country dropdown to be clickable
	    wait.until(ExpectedConditions.elementToBeClickable(EditCountyDrop));
	    EditCountyDrop.click();

	    // Wait for the country search input to be visible and interactable
	    wait.until(ExpectedConditions.visibilityOf(EditCountrySearch));
	    EditCountrySearch.sendKeys(NewCountry);

	    // Wait for the country options to be available and clickable
	    wait.until(ExpectedConditions.visibilityOfAllElements(EditCountryDrop));
	    for (WebElement SelectCountry : EditCountryDrop) {
	        if (SelectCountry.getText().trim().equals(NewCountry)) {
	            SelectCountry.click();
	            break;
	        }
	    }

	    saveapply.click();
	    close.click();
	}
*/
	 
}
