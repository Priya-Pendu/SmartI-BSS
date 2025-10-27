package MasterPage;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import LoginTest.LoginPage;
import Utilities.BasePage;



public class OrganizationPage extends BasePage
{
	   WebDriver driver;
	 
	   
	   public OrganizationPage (WebDriver driver)
	   {
	        super(driver);
	    }

	   // Locators of Add Organization
	    @FindBy(xpath = "//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Username']") 
	    WebElement Username;
	    @FindBy(xpath = "//input[@id='BuildingSolutionSuite_Membership_LoginPanel0_Password']") 
	    WebElement Password;
	    @FindBy(xpath = "//button[@id='BuildingSolutionSuite_Membership_LoginPanel0_LoginButton']") 
	    WebElement LoginButton;
	    @FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]") 
	    WebElement AccessManagment;
	    @FindBy(xpath = "//i[@class='nav-icon fa fa-th-list']") 
	    WebElement Master;
	    @FindBy (xpath = "//a[@href='/Organization/Organization']//span[contains(text(),'Organization')]") 
	    WebElement OrganizationMenubtn;
	    @FindBy (xpath="//span[normalize-space()='New Organization']") 
	    WebElement NewOrganization;
	    @FindBy (xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog10_OrganizationTypeId']//b[@role='presentation']") 
	    WebElement OrganizationType;
	    @FindBy(xpath ="//input[@id='s2id_autogen2_search']") 
	    WebElement SearchOrganization;
	    @FindBy(xpath ="//ul[@class='select2-results']/*") 
	    List<WebElement> dropdownOptions;
	    @FindBy(name="OrganizationName")
	    WebElement OrganizationName;
	    @FindBy(name="OrganizationCode")
	    WebElement OrganizationCode;
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog10_Location']//b[@role='presentation']") 
	    WebElement LocationDrop;
	    @FindBy(xpath="//input[@id='s2id_autogen3_search']") 
	    WebElement LocationSearch;
	    @FindBy(xpath ="//ul[@id='select2-results-3']/*") 
	    List<WebElement> LocationOptions;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_Address") 
	    WebElement Add;
	    @FindBy(name="EmailId") 
	    WebElement Email;
	    @FindBy (xpath = "//input[@class='emaildomain']") 
	    WebElement MailDomain ;
	    @FindBy(name = "ContactNo") 
	    WebElement Number;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_StartDate") 
	    WebElement Sdate;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_EndDate") 
	    WebElement Edate;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_EmployeeStrength") 
	    WebElement EmpStrength;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_TypeofService") 
	    WebElement Service;
	    @FindBy(id="BuildingSolutionSuite_Organization_OrganizationDialog10_AuditRemark") 
	    WebElement Remark;
	    @FindBy(id ="BuildingSolutionSuite_Organization_OrganizationDialog6_IsActive") 
	    WebElement isActive;
	    @FindBy(xpath = "//span[normalize-space(text())='Save']") 
	    WebElement save;
	    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']") 
	    WebElement Alert;
	    @FindBy(xpath="//button[normalize-space()='OK']") 
	    WebElement ok;
	    @FindBy(xpath="//button[@class='panel-titlebar-close']") 
	    WebElement BackButton;
	    @FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]/a")
	    List <WebElement> Organization;
	    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	    WebElement SearchOrganizationName;
	    @FindBy(xpath="//div[@class='panel-titlebar-text']")
	    WebElement NewOrgPageTitle;
	        
	    
	    //Locators of Edit Organization
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog30_OrganizationTypeId']//b[@role='presentation']")
	    WebElement EditOrgType;
	    @FindBy(xpath="//input[@id='s2id_autogen2_search']") 
	    WebElement EditSearchOrg;
	    @FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	    WebElement EditdropdownOptions;
	    @FindBy(name="OrganizationName")
	    WebElement EditOrgName;
	    @FindBy(name="OrganizationCode")
	    WebElement EditOrgCode;
	    @FindBy(css="div[id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog50_Location'] b[role='presentation']")
	    WebElement EditLocationDrop;
	    @FindBy(xpath="//input[@id='s2id_autogen7_search']")
	    WebElement EditLocationSearch;
	    @FindBy(xpath="//ul[@id='select2-results-5']/*")
	    List <WebElement> EditLocationOptions;
	    @FindBy(name="Address")
	    WebElement EditAdd;
	    @FindBy (name="EmailId")
	    WebElement EditEmail;
	    @FindBy (xpath="//input[@class='emaildomain']")
	    WebElement EditMailDomain;
	    @FindBy(name="StartDate")
	    WebElement EditSDate;
	    @FindBy(name="EndDate")
	    WebElement EditEDate;
	    @FindBy(name="EmployeeStrength")
	    WebElement EditEmpStregnth;
	    @FindBy(name="TypeofService")
	    WebElement EditSeervice;
	    @FindBy (name="AuditRemark")
	    WebElement EditRemark;
	    @FindBy(xpath="//span[normalize-space()='Save']")
	    WebElement EditSaveDetails;
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog10_OrganizationTypeId']//abbr[@class='select2-search-choice-close']")
	    WebElement Cross;
	    @FindBy(xpath ="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog10_Location']//abbr[@class='select2-search-choice-close']")
	    WebElement EditCross;
	    @FindBy(xpath="//span[@id='select2-chosen-2']")
	    WebElement SelectedOrgType;
	    @FindBy(xpath="//span[@id='select2-chosen-3']")
	    WebElement SelectedLocation;
	    @FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']")
	    WebElement Excelbtn;
	    @FindBy(xpath ="//div[@title='PDF']//span[@class='button-inner']")
	    WebElement Pdfbtn;
	    
	    //ActionMethod 
	    
	    public void InitialSteps()
	    {
	    	LoginPage lp = new LoginPage(driver);
	    	AccessManagment.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(Master)).click();
	    	OrganizationMenubtn.click();;
	    }
	    
	    //TS0017 - Verify wheather "New Organization' page display or not
		public void VerifyNewOrganizationPage() throws InterruptedException {
			InitialSteps();
			OrganizationMenubtn.click();
			NewOrganization.click();
			Thread.sleep(3000);
			Assert.assertEquals(NewOrgPageTitle.getText(), "New Organization");
			System.out.println("New Organization page is displayed");
			BackButton.click();
		}
		
		//TS0018 - Fill Organization Details
	    public void AddOrganization(String Org, String OrgName, String OrgCode, String Location, String Address, String EmailId, String ContactNo, 
	    		                    String StartDate, String EndDate, String EmployeeStrength, String TypeofService, String AuditRemark) throws InterruptedException 
	    {
	    	//Step1
	    	AccessManagment.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(Master)).click();
	    	OrganizationMenubtn.click();
	    	NewOrganization.click();  
	    	OrganizationType.click(); 
			
	       for (WebElement value : dropdownOptions ) 
	       {
		
		    if(value.getText().trim().equalsIgnoreCase(Org))
		    	{
		    		value.click();
		    		break;
		    	}
	       }
	       
	       //Step2
	       	OrganizationName.sendKeys(OrgName);
	    	OrganizationCode.sendKeys(OrgCode);
	    	
	    	
	    	//Step3
	    	LocationDrop.click(); 
	    	      
	    	LocationSearch.sendKeys(Location);
	    	Thread.sleep(3000);
		       for (WebElement value : LocationOptions ) 
		       {
			
			    if(value.getText().trim().equals(Location))
			    	{
			    		value.click();
			    		break;
			    	}
			    else
			    {
			    	System.out.println("The given location is not matched");
			    }
		       }
		       
		       //Step4
		       Add.sendKeys(Address);
	    	   Email.sendKeys(EmailId);
	    	   MailDomain.sendKeys("gmail.com");
	    	   Thread.sleep(5000);
	    	   Number.sendKeys(ContactNo);
	    	   
	    	   //Step5
	    	   Sdate.sendKeys(StartDate);
	    	   Edate.sendKeys(EndDate);
	    	   EmpStrength.sendKeys(EmployeeStrength);
	    	   Service.sendKeys(TypeofService);
	    	   Remark.sendKeys(AuditRemark);
	    	   
	    	   
	    	   //Step6
	    	   save.click();
		    
	    	   Thread.sleep(3000);
	    	   Assert.assertTrue(NewOrganization.isDisplayed());
	    	    
	    }
	    
	    //TS0019 - View an existing Organization
	    public void viewOrg(String ORG) throws InterruptedException

	    {
	    	InitialSteps();
	    	SearchOrganizationName.sendKeys(ORG);
	    	Thread.sleep(3000);
	    	
	    	//Clicking on organization to edit
	    	/*if(Organization.getText().equals(ORG))
	    	{
	    		Organization.click();
	    		Thread.sleep(3000);
	    	}*/
	    	System.out.println(SelectedOrgType.getText());
	    	System.out.println(EditOrgName.getAttribute("value"));
	    	System.out.println(EditOrgCode.getAttribute("value"));
	    	System.out.println(SelectedLocation.getAttribute("value"));
	    	System.out.println(EditAdd.getAttribute("value"));
	    	System.out.println(EditEmail.getAttribute("value"));
	    	System.out.println(EditSDate.getAttribute("value"));
	    	System.out.println(EditEDate.getAttribute("value"));
	    	System.out.println(EditEmpStregnth.getAttribute("value"));
	    	System.out.println(EditSeervice.getAttribute("value"));
	    	System.out.println(EditRemark.getAttribute("value"));
			
	    }
	    
	    //TS0020 - Edit an existing Organization
	    public void EditOrganization(String orgName, String newOrgType, String newOrgName, String newOrgCode, String newLocation,
                String newAddress, String newEmail, String contact, int newStartDate, int newEndDate,
                String employeeStrength, String typeOfService, String newAuditRemark) throws InterruptedException {

		InitialSteps();
		
		SearchOrganizationName.clear();
		SearchOrganizationName.sendKeys(orgName);
		Thread.sleep(3000);
		
		// Clicking on organization to edit
		boolean found = false;
		for (WebElement orgElement : Organization) {
		if (orgElement.getText().equalsIgnoreCase(orgName)) {
		orgElement.click();
		Thread.sleep(3000);
		found = true;
		break; // stop after finding and clicking
		}
		}
		
		if (!found) {
		System.out.println("Organization not found: " + orgName);
		return;
		}
		
		// Change Org name and code
		EditOrgName.clear();
		EditOrgName.sendKeys(newOrgName);
		
		EditOrgCode.clear();
		EditOrgCode.sendKeys(newOrgCode);
		
		// Change address, email ID, etc.
		EditAdd.clear();
		EditAdd.sendKeys(newAddress);
		
		EditEmail.clear();
		EditEmail.sendKeys(newEmail);
		
		EditMailDomain.clear();
		EditMailDomain.sendKeys("gmail.com");
		
		// Update contact number
		Number.clear();
		Number.sendKeys(contact);
		
		// Change start and end date
		EditSDate.clear();
		EditSDate.sendKeys(String.valueOf(newStartDate));
		
		EditEDate.clear();
		EditEDate.sendKeys(String.valueOf(newEndDate));
		
		// Update employee strength, type of service, audit remark
		EditEmpStregnth.clear();
		EditEmpStregnth.sendKeys(employeeStrength);
		
		EditSeervice.clear();
		EditSeervice.sendKeys(typeOfService);
		
		EditRemark.clear();
		EditRemark.sendKeys(newAuditRemark);
		
		// Save details
		EditSaveDetails.click();
		Thread.sleep(5000);
		
		System.out.println("Organization details updated successfully for: " + newOrgName);
		}

	    private CharSequence Stirngof(int nStartD) {
			// TODO Auto-generated method stub
			return null;
		}

	    //TS0022 - Export Organization list to Excel
		public void ExportToExcel() throws InterruptedException 
		{
			InitialSteps();
			Excelbtn.click();
			Thread.sleep(10000);
		}

		//TS0023 - Export Organization list to PDF
	     public void PdfExport() throws InterruptedException
	     {
	    	 InitialSteps();
	    	 Pdfbtn.click();
	    	 Thread.sleep(10000);
	     }
	      
	     //TS0024 - Search Organization using Search bar
	    public void SearchBar(String orgName) throws InterruptedException
	    {
	    	InitialSteps();
	    	SearchOrganizationName.clear();
			SearchOrganizationName.sendKeys(orgName);
			Thread.sleep(3000);
			
			// Clicking on organization to edit
			boolean found = false;
			for (WebElement orgElement : Organization) {
			if (orgElement.getText().equalsIgnoreCase(orgName)) {
			System.out.println("Organization details: " +orgElement.getText());
			Thread.sleep(3000);
			found = true;
			break; // stop after finding and clicking
			}
			}
			
			if (!found) {
			System.out.println("Organization not found: " + orgName);
			return;
			}
			
			//Se
	    }
	       
}
