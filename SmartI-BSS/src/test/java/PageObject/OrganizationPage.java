package PageObject;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
	    @FindBy(xpath="//div[@class='slick-cell l1 r1']/a")
	    WebElement Organization;
	    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	    WebElement SearchOrganizationName;
	        
	    
	    //Locators of Edit Organization
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog30_OrganizationTypeId']//b[@role='presentation']")
	    WebElement EditOrgType;
	    @FindBy(xpath="//input[@id='s2id_autogen2_search']") 
	    WebElement EditSearchOrg;
	    @FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	    WebElement EditdropdownOptions;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_OrganizationName']")
	    WebElement EditOrgName;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_OrganizationCode']")
	    WebElement EditOrgCode;
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog30_Location']//b[@role='presentation']")
	    WebElement EditLocationDrop;
	    @FindBy(xpath="//input[@id='s2id_autogen5_search']")
	    WebElement EditLocationSearch;
	    @FindBy(xpath="//ul[@id='select2-results-5']/*")
	    List <WebElement> EditLocationOptions;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_Address']")
	    WebElement EditAdd;
	    @FindBy (xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_EmailId']")
	    WebElement EditEmail;
	    @FindBy (xpath="//input[@class='emaildomain']")
	    WebElement EditMailDomain;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_StartDate']")
	    WebElement EditSDate;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_EndDate']")
	    WebElement EditEDate;
	    @FindBy(xpath="//input[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_EmployeeStrength']")
	    WebElement EditEmpStregnth;
	    @FindBy(xpath="//textarea[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_TypeofService']")
	    WebElement EditSeervice;
	    @FindBy (xpath="//textarea[@id='BuildingSolutionSuite_Organization_OrganizationDialog30_AuditRemark']")
	    WebElement EditRemark;
	    @FindBy(xpath="//span[normalize-space()='Save']")
	    WebElement EditSaveDetails;
	    @FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Organization_OrganizationDialog10_OrganizationTypeId']//abbr[@class='select2-search-choice-close']")
	    WebElement Cross;
	    
	    //Delete Organization Locators
	    
	    @FindBy(xpath="//span[normalize-space()='Delete']")
	    WebElement DeleteOrganization;
	    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-ConfirmDialog ui-dialog-buttons ui-draggable']")
	    WebElement ConfirmationMSG;
	    @FindBy(xpath="//button[normalize-space()='Yes']")
	    WebElement Yes;
	    
	    //ActionMethod 
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
	    	   System.out.println(Alert.getText());
	    	   ok.click();
	    	   BackButton.click();
	    	    
	    }
	    
	    
	    
	    public void EditOrganization(String ORG, String NewORGType, String NewORGName, String NewORGCode, String NewLocation, 
	    							String NewAdd, String NewEmail, String NStartD, String NEndD, String EmployeeS, String TypeofS, String NAudit) throws InterruptedException
	    {
	    	SearchOrganizationName.sendKeys(ORG);
	    	Thread.sleep(3000);
	    	
	    	//Clicking on organization to edit
	    	if(Organization.getText().equals(ORG))
	    	{
	    		Organization.click();
	    		Thread.sleep(3000);
	    		
	    	}
	    	else
	    	{
	    		System.out.println("The organization is not available.");
	    	}
	    	
	    	/*
	    	//change organization 
	    	EditOrgType.click(); 
	    	EditSearchOrg.sendKeys(NewORGType);
	    	
			
		       for (WebElement value : dropdownOptions ) 
		       {
			
			    if(value.getText().trim().equalsIgnoreCase(NewORGType))
			    	{
			    		value.click();
			    		break;
			    	}
		       }  */
	    	
		       //Change Org name and code 
		       EditOrgName.sendKeys(NewORGName);
		       EditOrgCode.sendKeys(NewORGCode);
		    	
		       //Change Location
		       Cross.click();
		       EditLocationDrop.click(); 
	    	      
		       EditLocationSearch.sendKeys(NewLocation);
		    	Thread.sleep(3000);
			       for (WebElement value : EditLocationOptions ) 
			       {
				
				    if(value.getText().trim().equals(NewLocation))
				    	{
				    		value.click();
				    		break;
				    	}
				    else
				    {
				    	System.out.println("The given location is not matched");
				    }
			       }
			       
			       
			   //Change address,email id, 
			       EditAdd.sendKeys(NewAdd);
			       EditEmail.sendKeys(NewEmail);
			       EditMailDomain.sendKeys("gmail.com");
			       
		    //change start date, end date, employeee strength, type of service, audit remark
			       EditSDate.sendKeys(NStartD);
			       EditEDate.sendKeys(NEndD);
			       EditEmpStregnth.sendKeys(EmployeeS);
			       EditSeervice.sendKeys(TypeofS);
			       EditRemark.sendKeys(NAudit);
		    	   
		    //save details
			       EditSaveDetails.click();
				    
		    	   Thread.sleep(3000);
		    	   
	    }
	    	
	      
	    
	    public void DeleteOrganization(String ORG) throws InterruptedException
	    {
	    	//search organization 
	    	SearchOrganizationName.sendKeys(ORG);
	    	Thread.sleep(3000);
	    	
	    	//Clicking on organization to edit
	    	if(Organization.getText().equals(ORG))
	    	{
	    		Organization.click();
	    		Thread.sleep(3000);
	    		
	    	}
	    	else
	    	{
	    		System.out.println("The organization is not available.");
	    	}
	    	
	    	DeleteOrganization.click();
	    	
	    	System.out.println(ConfirmationMSG.getText());
	    	Yes.click();
	    	
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    	 js.executeScript("window.scrollBy(1000, 0);");
	    }
	      
	      
	      
	       
}
