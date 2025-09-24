	package MasterPage;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import LoginTest.LoginPage;
import Utilities.BasePage;
import Utilities.MaxCharacterLenght;

public class LocationPage extends BasePage {
    WebDriver driver;
    LoginPage lp;
    
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
    @FindBy(xpath="//a[@class='dropdown-toggle']") WebElement UserProfile;
    @FindBy(xpath="//a[normalize-space()='Logout']") WebElement Logout;
    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement SearchLocation;
	@FindBy(xpath = "//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") WebElement Username;
	@FindBy(xpath ="//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") WebElement Password;
	@FindBy(xpath = "//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") WebElement LoginButton;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_LocationMasterDialog8_IsShared']") WebElement IsShared;
	@FindBy(xpath="//div[@class='panel-titlebar-text']") WebElement NewLocTitle;
	@FindBy(xpath = "//div[@class='slick-cell l0 r0']/a") WebElement SLocationResult;
	@FindBy(xpath="//div[@title='Excel']//div[@class='button-outer']") WebElement Excelbtn;
    
    
    //ActionMethods
    public void InitialSteps()
    {
    	LoginPage lp = new LoginPage(driver);
    	AccessManagment.click();
    	wait.until(ExpectedConditions.elementToBeClickable(Master)).click();
    	Location.click();
    }
    
    //TS0001 - check location added in one company admin gets reflected in another company admin or not 
	public void CheckLocationInOtherCompany(String Name, String Code) throws InterruptedException 
	{
		InitialSteps();
		NewLocationMaster.click();
		wait.until(ExpectedConditions.elementToBeClickable(LocationName)).sendKeys(Name);
        wait.until(ExpectedConditions.elementToBeClickable(LocationCode)).sendKeys(Code);
        IsShared.click();
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        Thread.sleep(2000);
        logger.info("Location Added in First Company");
        UserProfile.click();
        Logout.click();
        Thread.sleep(2000);
        Username.sendKeys("enviro");
	    Password.sendKeys("Smarti@123");
	    LoginButton.click();
	    Thread.sleep(2000);
	    InitialSteps();
	    Thread.sleep(2000);
	    SearchLocation.sendKeys(Name);
	   Assert.assertTrue(FirstColumn.getText().equals(Name), "Location not found in second company");
        
	}
	
	//TS0002 - Verify whether "New Location" page displayed or not
	public void VerifyNewLocationPage()
	{
		InitialSteps();
		NewLocationMaster.click();
		Assert.assertTrue(NewLocTitle.getText().contains("New Location Master"), "New Location Page is not displayed");
		logger.info("New Location Page is displayed");
	}
	
	//TS0003 - Verify the functionality of location
    public void VerifyAddLocation(String Name, String code) throws InterruptedException
    {
        InitialSteps();   	
        NewLocationMaster.click();
        // Enter location name and code
        wait.until(ExpectedConditions.elementToBeClickable(LocationName)).sendKeys(Name);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(LocationCode)).sendKeys(code);
        Thread.sleep(2000);
        // Save the location
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        Thread.sleep(2000);
        Assert.assertTrue(NewLocationMaster.isDisplayed(), "Location not saved");
    }
    
   //TS0004 - Verify adding location with using maximum character limit of the text field.
    public void VerifyMaxCharLimit() throws InterruptedException
    {
		InitialSteps();
		NewLocationMaster.click();
		MaxCharacterLenght.getMaxInputLength(LocationName, "C", 200);	
		Thread.sleep(2000);
		logger.info("Maximum character limit for Location Name is: " + LocationName.getAttribute("value").length());
		MaxCharacterLenght.getMaxInputLength(LocationCode, "3", 100);
		Thread.sleep(2000);
		logger.info("Maximum character limit for Location Code is :" + LocationCode.getAttribute("value").length());
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
    }
    
    //TS0005 - View an existing Location
    public void viewExistingLocation(String name) throws InterruptedException {
        InitialSteps();
        SearchLocation.clear();
        SearchLocation.sendKeys(name);
        Thread.sleep(2000);
        if (SLocationResult.getText().trim().equalsIgnoreCase(name)) {
        	Thread.sleep(2000);
            SLocationResult.click();

            String locName = LocationName.getAttribute("value");
            String locCode = LocationCode.getAttribute("value");

            System.out.println("Location Name: " + locName);
            System.out.println("Location Code: " + locCode);

            Assert.assertEquals(locName, name, "Location name does not match");
        } else {
            Assert.fail("Search result did not match the expected name");
        }
    }

    //TS0006 - Edit an existing Location
    public void EditLocation(String SearchLocation, String Name, String Code, String Details) throws InterruptedException {
    	InitialSteps();
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
        BackButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(NewLocationMaster.isDisplayed(), "Location not updated");
    }

    
    //TS0008 - Export Location list to Excel
    public void VerifyExcelbtn() throws InterruptedException
    {
    	InitialSteps();
    	Excelbtn.click();
    	Thread.sleep(10000);
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

