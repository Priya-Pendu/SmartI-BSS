package MasterPage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Utilities.BasePage;

public class LocationPage extends BasePage {
    WebDriver driver;
    
    public LocationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]") WebElement AccessManagment;
    @FindBy(xpath = "//i[@class='nav-icon fa fa-th-list']") WebElement Master;
    @FindBy(xpath = "//span[normalize-space()='Company']") WebElement Company;
    @FindBy(xpath = "//a[@href='/Master/LocationMaster']//span[contains(text(),'Location')]") WebElement Location;
    @FindBy(xpath="//span[normalize-space()='New Location Master']") WebElement NewLocationMaster;
    @FindBy(xpath ="//input[@id='BuildingSolutionSuite_Master_LocationMasterDialog8_LocationName']") WebElement LocationName;
    @FindBy(xpath ="//input[@id='BuildingSolutionSuite_Master_LocationMasterDialog8_LocationCode']") WebElement LocationCode;
    @FindBy(xpath ="//span[normalize-space()='Save']") WebElement save;
    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement SearchBar;
    @FindBy(xpath ="//button[@class='panel-titlebar-close'] ") WebElement BackArrowButton;
    @FindBy(xpath="//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/*") List <WebElement> LocationList;
    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement SLocation;
    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']") WebElement Alert;
    @FindBy(xpath ="//button[normalize-space()='OK']") WebElement ok;
    @FindBy(xpath="//button[@class='panel-titlebar-close']") WebElement BackArrow; 
    @FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]/*") WebElement FirstColumn;
    @FindBy(xpath="//textarea[@id='BuildingSolutionSuite_Master_LocationMasterDialog8_Details']") WebElement DetailsInput;
    @FindBy(xpath="//div[@class='slick-cell l0 r0']/a") WebElement UpdatedLocation;
    @FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']") WebElement ApplyChanges;
    @FindBy(name="LocationName") WebElement EditLocationN;
    @FindBy(name="LocationCode") WebElement EditLocationC;
    @FindBy(name="Details") WebElement EditDetails;
    @FindBy(xpath="//button[@class='panel-titlebar-close']") WebElement BackButton; 
    @FindBy(xpath="//span[normalize-space()='Delete']") WebElement Delete;
    @FindBy(xpath="//div[@class=\"slick-cell l5 r5\"]/span") WebElement IsActive;
    @FindBy(xpath="//button[normalize-space()='Yes']") WebElement Yes;
    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-ConfirmDialog ui-dialog-buttons ui-draggable']") WebElement ConfirmationMSG;
    
    
    //ActionMethods
    public void InitialSteps()
    {
    	AccessManagment.click();
    	wait.until(ExpectedConditions.elementToBeClickable(Master)).click();
    	Location.click();
    }
    
    //TS0001 - check location added in one company admin gets reflected in another company admin or not 
	public void CheckLocationInOtherCompany(String Name, String Code) 
	{
		NewLocationMaster.click();
		wait.until(ExpectedConditions.elementToBeClickable(LocationName)).sendKeys(Name);
        wait.until(ExpectedConditions.elementToBeClickable(LocationCode)).sendKeys(Code);
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        logger.info("Location Added in First Company");
	}
	
	
    public void click_Location_btn(String Name, String code) throws InterruptedException
    {
    	
    	
        NewLocationMaster.click();

        // Enter location name and code
        wait.until(ExpectedConditions.elementToBeClickable(LocationName)).sendKeys(Name);
        wait.until(ExpectedConditions.elementToBeClickable(LocationCode)).sendKeys(code);

        // Save the location
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        
        System.out.println(Alert.getText());
        ok.click();
        BackArrow.click();
        
    }
    
   
    public void EditLocation(String SearchLocation, String Name, String Code, String Details) throws InterruptedException {
        
    	SLocation.sendKeys(SearchLocation);
    	Thread.sleep(3000);
    	
    	System.out.println(UpdatedLocation.getText());
    	
    	if(UpdatedLocation.getText().equals(SearchLocation))
    	{
    		UpdatedLocation.click();
        	Thread.sleep(3000);
        	
    	}
    	
    	EditLocationN.clear();
    	EditLocationN.sendKeys(Name);
    	EditLocationC.clear();
    	EditLocationC.sendKeys(Code);
    	EditDetails.sendKeys(Details);
        ApplyChanges.click();
        Thread.sleep(3000);
        System.out.println(Alert.getText());
        ok.click();
        BackButton.click();
        
    }

    
   
    public void DeleteLocation(String LocationName) throws InterruptedException
    {
    	SLocation.clear();
    	SLocation.sendKeys(LocationName);
    	Thread.sleep(3000);
    	System.out.println(UpdatedLocation.getText());
    	if(UpdatedLocation.getText().equals(LocationName))
    	{
    		UpdatedLocation.click();
        	Thread.sleep(3000);
        	
    	}
    	
    	Delete.click();
    	Thread.sleep(3000);
    	System.out.println(ConfirmationMSG.getText());
    	Yes.click();
    	
    	//ApplyChanges.click();
    	SLocation.clear();
    	SLocation.sendKeys(LocationName);
    	if(IsActive.isSelected())
    	{
    		System.out.println("Location is inactive");
    	}
    	else
    	{
    		System.out.println("Location is active not deleted.");
    	}
    	
    	
    }
}

