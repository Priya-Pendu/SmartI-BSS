package MasterPage;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import LoginTest.LoginPage;
import Utilities.BasePage;



public class DivisionPage extends BasePage

{
	WebDriver driver;
	
	public DivisionPage(WebDriver driver) {
		super(driver);
	}
	
	//AddLocation Locators
	@FindBy (xpath="//p[normalize-space()='Access']")
	WebElement AccessManagement;
	@FindBy(xpath="//b[@role='presentation']") 
	WebElement LocationDrop ;
	@FindBy(xpath="//ul[@id='select2-results-1']/*") 
	List <WebElement> LocationOptions;
	@FindBy(name="DivisionCode") 
	WebElement CodeText;
	@FindBy(name ="DivisionName") 
	WebElement Name;
	@FindBy(id ="BuildingSolutionSuite_Master_DivisionDialog8_AuditRemark") 
	WebElement Remark;
	@FindBy (xpath = "//span[normalize-space()='Save']") 
	WebElement savebutton;
	@FindBy(id = "BuildingSolutionSuite_Membership_LoginPanel0_Username") 
	WebElement User;
	@FindBy(id="BuildingSolutionSuite_Membership_LoginPanel0_Password") 
	WebElement Pass;
	@FindBy(id ="BuildingSolutionSuite_Membership_LoginPanel0_LoginButton") 
	WebElement Login;
	@FindBy(xpath ="//p[contains(@class,'title-text')][contains(text(),'Access')]") 
	WebElement AccessModule;
	@FindBy(xpath = "//i[@class='nav-icon fa fa-th-list']") 
	WebElement MasterDropBtn;
	@FindBy(xpath ="//a[@href='/Master/Division']//span[contains(text(),'Division')]") 
	WebElement Divisionbtn;
	@FindBy(xpath ="//span[normalize-space()='New Division']") 
	WebElement NewDivision;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement Yes;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrow;
	//UpdateDivision locators
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement EditSearchDivi;
	@FindBy(xpath="//div[@class='slick-cell l2 r2']/a")
	WebElement Division;
	@FindBy(xpath="//b[@role='presentation']")
	WebElement EditLocationDrop;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']")
	WebElement EditSearchLocation;
	@FindBy (xpath="//ul[@class='select2-results']/*")
	List <WebElement> EditLocationOptions;
	@FindBy(xpath="//input[@name=\"DivisionCode\"]")
	WebElement EditCode;
	@FindBy(xpath="//input[@name=\"DivisionName\"]")
	WebElement EditName;
	@FindBy(xpath="//div[@title='Apply Changes']//div[@class='button-outer']")
	WebElement Applychange;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrowbtn;
	@FindBy (xpath = "//a[@href='/Organization/Organization']//span[contains(text(),'Organization')]") 
    WebElement OrganizationMenubtn;
	@FindBy(xpath="//div[@class='panel-titlebar-text']")
	WebElement NDivisionPageTitle;
	@FindBy(xpath="//span[@id='select2-chosen-1']")
	WebElement ExistLocation;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BacktoDivi;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']")
	WebElement excelbtn;
	@FindBy(xpath="//div[@title='PDF']//div[@class='button-outer']")
	WebElement pdfbtn;
	@FindBy(xpath="//div[@class=\"slick-cell l2 r2\"]")
	WebElement searchDiviN;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]")
	WebElement searchDiviC;
	
	//ActionMethods
	
	 public void InitialSteps()
	    {
	    	//LoginPage lp = new LoginPage(driver);
	    	AccessManagement.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(MasterDropBtn)).click();
	    	MasterDropBtn.click();
	    	Divisionbtn.click();
	    }
	 
	   
	 //TS0030 - Create a new Division
		public void VerifyNewDivisionPage() throws InterruptedException 
		{
			InitialSteps();
			NewDivision.click();
			Thread.sleep(2000);
			Assert.assertTrue(NDivisionPageTitle.getText().contains("New Division"));
		}
	 
		//TS0031 - Fill Division Details
	   public void AddDivision(String Location, String Code, String DivisionName, String AuditRemark) throws InterruptedException
	  {
		//open the division page
		InitialSteps();
		NewDivision.click();
		
		//select the location
		LocationDrop.click();
		Thread.sleep(3000);
		
		for(WebElement value : LocationOptions)
		{
			if(value.getText().trim() .equals(Location))
			{
				value.click();
				break;
			}
		}
		
		//fill the other fields
		CodeText.sendKeys(Code);
		Name.sendKeys(DivisionName);
		Remark.sendKeys(AuditRemark);
		//save the details
		savebutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(NewDivision.isDisplayed());
		System.out.println("Division Added Successfully..");
		
	}

	   //TS0032 - View an existing Division
	   public void ViewExistDivi(String Divi) throws InterruptedException
	   {
		   InitialSteps() ;
		   EditSearchDivi.sendKeys(Divi);
			Thread.sleep(3000);
			
			if(Division.getText().equals(Divi))
			{
				Division.click();
				System.out.println("Division details are:" + ExistLocation.getText() +", "+EditCode.getAttribute("value")
				+", "+EditName.getAttribute("value"));
			}
			BacktoDivi.click();
			Assert.assertTrue(NewDivision.isDisplayed());
	   }
	
	   //TS0033 - Edit an existing Division
	   public void EditDivision(String Divi,String NewLocation, String NewCode, String NewName ) throws InterruptedException
		{
		    InitialSteps();
			EditSearchDivi.sendKeys(Divi);
			Thread.sleep(3000);
			
			if(Division.getText().equals(Divi))
			{
				Division.click();	
			}
			else
			{
				System.out.println("Division is not available");
			}
			
			//change the location
			EditLocationDrop.click();
			wait.until(ExpectedConditions.elementToBeClickable(EditSearchLocation));
			EditSearchLocation.sendKeys(NewLocation);
			
			for(WebElement value : EditLocationOptions)
			{
				if(value.getText().trim() .equals(NewLocation))
				{
					value.click();
					break;
				}
			}
			
			EditCode.clear();
			EditCode.sendKeys(NewCode);
			
			EditName.clear();
			EditName.sendKeys(NewName);
			Applychange.click();
			BackArrowbtn.click();
		}

	   //TS0034 - Export Division list to Excel
	   public void ExportExcel() throws InterruptedException
	   {
		   InitialSteps();
		   excelbtn.click();
		   Thread.sleep(10000);		   
	   }
	   
	   //TS0035 - Export Division list to PDF
	   public void ExportPDF() throws InterruptedException
	   {
		   InitialSteps();
		   pdfbtn.click();
		   Thread.sleep(10000);
	   }
	   
	   public void VerifySearchBar(String DiviName, String DiviCode) throws InterruptedException
	   {
		   InitialSteps();
		   EditSearchDivi.sendKeys(DiviName);
			Thread.sleep(3000);
			Assert.assertTrue(searchDiviN.getText().equals(DiviName));
			
			EditSearchDivi.clear();
			EditSearchDivi.sendKeys(DiviCode);
			Thread.sleep(3000);
			Assert.assertTrue(searchDiviC.getText().equals(DiviCode));
		   
	   }
}
