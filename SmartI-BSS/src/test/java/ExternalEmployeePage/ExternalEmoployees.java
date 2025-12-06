package ExternalEmployeePage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BasePage;

public class ExternalEmoployees extends BasePage 
{
	
	//Constructor
	public ExternalEmoployees(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[contains(@class,'title-text')][contains(text(),'Access')]")
	WebElement AccessManagement;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[6]/a[1]")
	WebElement Employee;
	@FindBy(xpath="//span[normalize-space()='External Employees']")
	WebElement ExternalEmp;
	@FindBy(xpath="//span[normalize-space()='New Non Employee Master']")
	WebElement NewNEMP;
	//organization locator
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_OrganizationID']//b[@role='presentation']")
	WebElement OrgDropD;
	@FindBy(xpath="//input[@id='s2id_autogen8_search']")
	WebElement SearchORG;
	@FindBy(xpath="//div[@class='select2-result-label']/*")
	List<WebElement> ORGOptions;
	//Division Locators
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_DivisionId']//b[@role='presentation']")
	WebElement DiviDrop;
	@FindBy(xpath="//input[@id='s2id_autogen16_search']")
	WebElement SearchDivi;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> DiviOptions; 
	//Location
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_LocationMasterId']//b[@role='presentation']")
	WebElement LocDrop;
	@FindBy(xpath="//input[@id='s2id_autogen15_search']")
	WebElement SearchLoc;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> LocOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_LocationMasterId']//abbr[@class='select2-search-choice-close']")
	WebElement LocClose;
	//Department
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_DepartmentId']//b[@role='presentation']")
	WebElement DepartmentDrop;
	@FindBy(xpath="//input[@id='s2id_autogen17_search']")
	WebElement SearchDepartment;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> DepartmentOptions;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_EmployeeCode']")
	WebElement EmpCode;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_SalutationId']//b[@role='presentation']")
	WebElement salDrop;
	@FindBy(xpath="//input[@id='s2id_autogen20_search']")
	WebElement SearchSal;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> SalOptions;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_FirstName']")
	WebElement FirstN;
	@FindBy(xpath="//input[@id=\"BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_LastName\"]")
	WebElement LastN;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog91_EmployeeTypeId']//b[@role='presentation']")
	WebElement EmpDrop;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_Gender']//b[@role='presentation']")
	WebElement GenderDrop;
	@FindBy(xpath="//input[@id='s2id_autogen21_search']")
	WebElement SearchGender;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> GenderOptions; 
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_DateOfJoining']")
	WebElement DateOfJ;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_AdharCardNo']")
	WebElement AddharN;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_BloodGroup']//b[@role='presentation']")
	WebElement BloodDrop;
	@FindBy(xpath="//input[@id='s2id_autogen25_search']")
	WebElement SearchBloodG;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> BloodOptions;
	@FindBy(xpath="//input[@name='Serenity_ImageUploadEditor48[]']")
	WebElement SelectFile;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_ResignDate']")
	WebElement ResignDate;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_Dob']")
	WebElement DOB;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_EmergencyNo']")
	WebElement EmgNo;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_ResiTelNo']")
	WebElement ResiNo;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_OffTelNo']")
	WebElement OfficialN;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_EmailAddress']")
	WebElement EmailA;
	@FindBy(xpath="//input[@class='emaildomain']")
	WebElement MailDomain;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_MobileNo']")
	WebElement MobNo;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_MiddleName']")
	WebElement MidName;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_MaritalStatusId']//b[@role='presentation']")
	WebElement MaritalDrop;
	@FindBy(xpath="//input[@id='s2id_autogen22_search']")
	WebElement SearchMStatus;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> MstatusOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_EmployeeTypeId']//b[@role='presentation']")
	WebElement EmpTDrop;
	@FindBy(xpath="//input[@id='s2id_autogen23_search']")
	WebElement SearchEmpT;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> EmpTOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_ManagerId']//b[@role='presentation']")
	WebElement ManagerDrop;
	@FindBy(xpath="//input[@id='s2id_autogen24_search']")
	WebElement SearchManager;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> ManagerOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_SubDepartmentId']//b[@role='presentation']")
	WebElement SubDepartmentDrop;
	@FindBy(xpath="//input[@id='s2id_autogen18_search']")
	WebElement SearchSubDepart;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> SubDeptOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_DesignationId']//b[@role='presentation']")
	WebElement DesignationDrop;
	@FindBy(xpath="//input[@id='s2id_autogen19_search']")
	WebElement SearchDesignation;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> DesignationOptions; 
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Savebtn;
	
	//Date selection
	@FindBy(xpath="//div[@class='field ResignDate col-md-6 col-lg-4']//img[@title='...']")
	WebElement Resigncal;
	@FindBy(xpath="//select[@class='ui-datepicker-month']/*")
	List <WebElement> Monthsdrop; 
	@FindBy(xpath="//select//option[@value=\"2\"]")
	WebElement CurrentMonth;
	@FindBy(xpath="//select//option[@selected=\"selected\"][@xpath=\"3\"]")
	WebElement CurrentYear;
	@FindBy(xpath="//select[@class='ui-datepicker-year']/*")
	List<WebElement> YearDrop;
	@FindBy(xpath="//tbody//tr/*/a")
	List<WebElement> Dates; 
	
	//Address
	@FindBy(xpath="//a[normalize-space()='Address']")
	WebElement Addressbtn;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_PermanentAddress']")
	WebElement PermanentAdd;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_PermanentCountryId']//b[@role='presentation']")
	WebElement CuntryDrop;
	@FindBy(xpath="//input[@id='s2id_autogen26_search']")
	WebElement SearchCountry;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List <WebElement> CountryList;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_PermanentStateId']//b[@role='presentation']")
	WebElement StateDrop;
	@FindBy(xpath="//input[@id='s2id_autogen27_search']")
	WebElement SearchState;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List<WebElement> StateList;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_PermanentCityId']//b[@role='presentation']")
	WebElement CityDrop;
	@FindBy(xpath="//input[@id='s2id_autogen28_search']")
	WebElement SearchCity;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List <WebElement> CityList;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_PermanentZipCode']")
	WebElement Pincode;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_CorrespondentAddress']")
	WebElement CorrespondentAdd;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_CorrespondentCountryId']//b[@role='presentation']")
	WebElement CountryDrop;
	@FindBy(xpath="//input[@id='s2id_autogen29_search']")
	WebElement SearchCountryC;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List<WebElement> CountryListC; 
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_CorrespondentstateId']//b[@role='presentation']")
	WebElement StateDropC;
	@FindBy(xpath="//input[@id='s2id_autogen30_search']")
	WebElement SearchStateC;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List<WebElement> StateListC;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_CorrespondentCityId']//b[@role='presentation']")
	WebElement CityDropC;
	@FindBy(xpath="//input[@id='s2id_autogen31_search']")
	WebElement SearchCityC;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List<WebElement> CityListC; 
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_CorrespondentZipCode']")
	WebElement PincodeC;
	
	//Advance Settings
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_DisplayNameOnController']")
	WebElement DisplayName;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_Status']")
	WebElement StatusCheckBox;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_IsBlackListed']")
	WebElement IsBlankListed;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_ApbEnable']")
	WebElement APBEnable;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_HolidayRestrict']")
	WebElement HolidayRestrict;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_MobilePermission']")
	WebElement MobilePermission;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_AutoApproval']")
	WebElement AutoApproval;
	@FindBy(xpath="//a[normalize-space()='Advance Settings']")
	WebElement AdvanceSettings;
	
	//Employee Card Management
	@FindBy(xpath="//a[normalize-space()='Employee Card Managment']")
	WebElement EmpCardManagement;
	@FindBy(xpath="//span[normalize-space()='New Employee Function Cards']")
	WebElement NewEmpFunctionCard;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_EmployeeFunctionCardsDialog91_CardType']//b[@role='presentation']")
	WebElement CardTypeDrop;
	@FindBy(xpath="//input[contains(@id,'s2id_autogen') and @type='text']")
	WebElement SearchCardType;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]")
	WebElement CardTypesOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_EmployeeFunctionCardsDialog91_CardPoolId']//b[@role='presentation']")
	WebElement RegularCardNoDrop;
	@FindBy(xpath="//input[@type='text'][@id='s2id_autogen32_search']")
	WebElement SearchRegularCard;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List<WebElement> CardNumbers; 
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_EmployeeFunctionCardsDialog91_CardExpiryDate']")
	WebElement CardExpiry;
	@FindBy(xpath="//div[@id='BuildingSolutionSuite_Employee_EmployeeFunctionCardsDialog91_Toolbar']//span[@class='button-inner'][normalize-space()='Save']")
	WebElement Save;
	
	//Entity
	@FindBy(xpath="//a[contains(text(),'Entity')]")
	WebElement Entity;
	@FindBy(xpath="//span[normalize-space()='New Entity']")
	WebElement NewEntity;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Employee-EmployeeFunctionCardsDialog s-Employee-EmployeeFunctionCardsDialog s-EmployeeFunctionCardsDialog ui-draggable ui-resizable flex-layout']")
	WebElement dialobox;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_BatchActivationDeactivationDialog91_EntityId']//b[@role='presentation']")
	WebElement EntitiesDrop;
	@FindBy(xpath="//input[@id='s2id_autogen35_search']")
	WebElement SearchEntity;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]/*")
	List<WebElement> EntityList;
	@FindBy(xpath="//div[@id='BuildingSolutionSuite_Default_BatchActivationDeactivationDialog91_Toolbar']//div[@class='tool-button save-and-close-button']//div[@class='button-outer']")
	WebElement SaveEntity;
	
	//Authentication
	@FindBy(xpath="//span[normalize-space()='New Employee Controller Authentication Type']")
	WebElement NewEmpAuthentication;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_EmployeeControllerAuthenticationTypeDialog91_Pin']")
	WebElement pin;
	@FindBy(xpath="//input[@id='s2id_autogen33_search']")
	WebElement SearchAuth;
	@FindBy(xpath="//ul[@id='select2-results-33']/*")
	List<WebElement> AuthTypeList;
	@FindBy(xpath="//div[@id='BuildingSolutionSuite_Employee_EmployeeControllerAuthenticationTypeDialog91_Toolbar']//span[@class='button-inner'][normalize-space()='Save']")
	WebElement SaveAuthType;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Employee_EmployeeControllerAuthenticationTypeDialog91_ControllerAuthenticationModeId']//b[@role='presentation']")
	WebElement AuthDrop;
	
	//User Login Details
	@FindBy(xpath="//a[normalize-space()='User Login Details']")
	WebElement UserLoginDetailsTab ;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Employee_NonEmployeeMasterDialog16_Password']")
	WebElement Pass;
	
	
	//ActionMethods

	public void AddEMP(String Org,String Location, String Divi, String Dept, String SubDept, String Designation,
			String EmpC,String Salutation, String FirstName, String MiddleN, String LastName, String Gender,
			String Mstatus, String Emptype, String ManagerName, 
			String MobileNo, String EmailAdd, String OfficialNo, 
			String ResiN, String EMGNo,
			String DateOFBirth, String Date, /*String ResignD*/ String ResignD, String RGMonth, String RGYear, String RGDate, 
			String BloodG, String AdharNumber  ) throws Exception
	{
		logger.info("****** Starting AddEMP ******");
		AccessManagement.click();
		logger.info("Clicked on AccessManagement ");
		
		Employee.click();
		logger.info("Clicked on Employee");
		
		ExternalEmp.click();
		logger.info("Clicked on External Employee");
		
		NewNEMP.click();
		logger.info("Clicked on New Employee");
		
		
		//WorkStation
		//Select Organization
		OrgDropD.click();
		Thread.sleep(3000);
		SearchORG.sendKeys(Org);
		Thread.sleep(3000);
		for(WebElement SelectOrg: ORGOptions)
		{
			if(SelectOrg.getText().trim().equals(Org))
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(SelectOrg));
				SelectOrg.click();
				logger.info("Element is Selected");
				break;
			}
		}
		
		
		// Location
		LocDrop.click();
		SearchLoc.sendKeys(Location);
		for(WebElement SelectLoc :LocOptions )
		{
			if(SelectLoc.getText().trim().equals(Location))
			{
				SelectLoc.click();
				break;
			}
		}
		
		
		//Division
		
		DiviDrop.click();
		Thread.sleep(3000);		
		SearchDivi.sendKeys(Divi);
		
		for(WebElement SelectDivi:DiviOptions )
		{
			if(SelectDivi.getText().trim().equals(Divi))
			{
				SelectDivi.click();
				break;
			}
				
		}
		
		
		//Department
		DepartmentDrop.click();
		SearchDepartment.sendKeys(Dept);
		for(WebElement SelectDepartment: DepartmentOptions)
		{
			if(SelectDepartment.getText().trim().equals(Dept))
			{
				SelectDepartment.click();
				break;
			}
		}
		
		//Sub Department
		SubDepartmentDrop.click();
		SearchSubDepart.sendKeys(SubDept);
		for(WebElement SelectSubDept: SubDeptOptions)
		{
			if(SelectSubDept.getText().trim().equals(SubDept))
			{
				SelectSubDept.click();
				break;
			}
		}
		
		//Desgination
		DesignationDrop.click();
		SearchDesignation.sendKeys(Designation);
		Thread.sleep(3000);
		for(WebElement SelectDesign : DesignationOptions)
		{
			if(SelectDesign.getText().trim().equals(Designation))
			{
				SelectDesign.click();
				break;
			}
		}
		
		
		//Basic Info
		
		EmpCode.sendKeys(EmpC);
		
		salDrop.click();
		SearchSal.sendKeys(Salutation);
		for(WebElement SelectSal: SalOptions )
		{
			if(SelectSal.getText().trim().equals(Salutation))
			{
				SelectSal.click();
			}
		}
		
		FirstN.sendKeys(FirstName);
		Thread.sleep(3000);
		MidName.sendKeys(MiddleN);
		LastN.sendKeys(LastName);
		//select gender
		GenderDrop.click();
		SearchGender.sendKeys(Gender);
		for(WebElement selectGen : GenderOptions)
		{
			if(selectGen.getText().trim().equals(Gender))
			{
				selectGen.click();
				break;
			}
		}
		//select marital status
		MaritalDrop.click();
		SearchMStatus.sendKeys(Mstatus);
		for(WebElement SelectMaritalS: MstatusOptions)
		{
			if(SelectMaritalS.getText().trim().equals(Mstatus))
			{
				SelectMaritalS.click();
				break;
			}
		}
		
		EmpTDrop.click();
		SearchEmpT.sendKeys(Emptype);
		for(WebElement SelectEtype: EmpTOptions)
		{
			if(SelectEtype.getText().trim().equals(Emptype))
			{
				SelectEtype.click();
				break;
			}
		}
		
		//Manager
		ManagerDrop.click();
		SearchManager.sendKeys(ManagerName);
		for(WebElement SelectManager : ManagerOptions)
		{
			if(SelectManager.getText().trim().equals(ManagerName))
			{
				SelectManager.click();
				break;
			}
		}
		
		//Contact INfo
		Thread.sleep(2000);
		
		if(MobNo.isDisplayed())
		{
			MobNo.sendKeys(MobileNo);
		}
		else
		{
			System.out.println("Mobno is not clickable");
		}
		
		Thread.sleep(3000);
		EmailA.sendKeys(EmailAdd);
		MailDomain.sendKeys("gmail.com");
		OfficialN.sendKeys(OfficialNo);
		ResiNo.sendKeys(ResiN);
		EmgNo.sendKeys(EMGNo);
		
		//Dates
		DOB.sendKeys(DateOFBirth);
		//DOBDrop.click();
		
		//Date of JOining
		DateOfJ.sendKeys(Date);
		
		/*
		Calenderbtn.click();
		Thread.sleep(3000);
		*/
		//Resign Date
		ResignDate.sendKeys(ResignD);
		//SelectDate(RGMonth, RGYear, RGDate);
        
		
		System.out.println(Monthsdrop);
		System.out.println(CurrentMonth.getText());
		
		//Image
		SelectFile.sendKeys("C:\\Users\\test2\\Downloads\\download.jpg");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(window.scrollTo(0,250))");
		
		//Misc
		BloodDrop.click();
		SearchBloodG.sendKeys(BloodG);
		Thread.sleep(4000);
		for(WebElement selectBLD :  BloodOptions)
		{
			if(selectBLD.getText().trim().equals(BloodG))
			{
				Thread.sleep(4000);
				selectBLD.click();
				break;
			}
		}
		AddharN.sendKeys(AdharNumber);
		
		
		
		jse.executeScript("window.scrollBy(window.scrollTo(0,0))");
		/*
		Savebtn.click();
		Thread.sleep(5000);
		*/
		
	}
	
///////DROP DOWN METHOED-------------------------------------------------->
	
	public void SelectDate(String Month, String Year, String Date) throws InterruptedException
	{
		Resigncal.click();
		
		if (CurrentMonth.getText().equals(Month)&&CurrentYear.getText().equals(Year))
		{
			for (WebElement dt : Dates) {
	            if (dt.getText().equals(String.valueOf(Date))) {
	                dt.click();  // Click the date if found
	               
	                break;
	            }
	        }
		}
		else
		{
			for(WebElement SelectM:Monthsdrop)
			{
				if(SelectM.getText().equals(Month))
				{
					SelectM.click();
					break;
				}
			}
			
			for(WebElement SelectY:YearDrop)
			{
				if(SelectY.getText().equals(Year))
				{
					SelectY.click();
					break;
				}
			}
			
			for (WebElement dt : Dates) {
	            if (dt.getText().equals(String.valueOf(Date))) {
	                dt.click();  // Click the date if found
	                
	                break;
	            }
	        }
		}
	
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(window.scrollTo(0,0))");
		Savebtn.click();
		Thread.sleep(5000);
	}  
	
	
	public void Address(String PermanentAddres, String Country, String State, String City, String PinCode, String CorrespondentAddress, 
			String CountryC, String StateC, String CityC, String PinCodeC)
	{
		Addressbtn.click();
		PermanentAdd.sendKeys(PermanentAddres);
		
		//Country
		CuntryDrop.click();
		SearchCountry.sendKeys(Country);
		for(WebElement SelectCountry:CountryList)
		{
			if(SelectCountry.getText().trim().equals(Country))
			{
				SelectCountry.click();
				break;
			}
		}
		
		//State
		StateDrop.click();
		SearchState.sendKeys(State);
		for(WebElement SelectState :StateList)
		{
			if(SelectState.getText().trim().equals(State))
			{
				SelectState.click();
				break;
			}
		}
		
		//City
		CityDrop.click();
		SearchCity.sendKeys(City);
		for(WebElement SelectCity:CityList)
		{
			if(SelectCity.getText().trim().equals(City))
			{
				SelectCity.click();
				break;
			}
		}
		
		//PinCode
		Pincode.sendKeys(PinCode);
		
		//Correspondence Address
		CorrespondentAdd.sendKeys(CorrespondentAddress);
		//Country
		CountryDrop.click();
		SearchCountryC.sendKeys(CountryC);
		for(WebElement SelectCountry :CountryListC)
		{
			if(SelectCountry.getText().trim().equals(CountryC))
			{
				SelectCountry.click();
				break;
			}
		}
		
		//State
		StateDropC.click();
		SearchStateC.sendKeys(StateC);
		for(WebElement SelectState :StateListC)
		{
			if(SelectState.getText().trim().equals(StateC))
			{
				SelectState.click();
				break;
			}
		}
		
		//City
		CityDropC.click();
		SearchCityC.sendKeys(CityC);
		for(WebElement SelectCity:CityListC)
		{
			if(SelectCity.getText().trim().equals(CityC)) 
			{
				SelectCity.click();
				break;
			}
		}
		
		//Pincode
		PincodeC.sendKeys(PinCodeC);
	}	
	
	public void AdvanceSettings(String displayName )
	{
		AdvanceSettings.click();
		
		DisplayName.sendKeys(displayName);
		if(!StatusCheckBox.isSelected())
		{
			StatusCheckBox.click();
		}else {
			System.out.println("Status is already selected");}
		//IsBlankListed
		if(!IsBlankListed.isSelected())
		{
			IsBlankListed.click();
		}else {System.out.println("IsBlankListed is already selected");}
		
		if(!APBEnable.isSelected())
		{
			APBEnable.click();
		}else {System.out.println("APBEnable is already selected");}
		
		if(!HolidayRestrict.isSelected())
		{
			HolidayRestrict.click();
		}else {System.out.println("HolidayRestrict is already selected");}
		
		if(!MobilePermission.isSelected())
		{
			MobilePermission.click();
		}else {System.out.println("MobilePermission is already selected");}
		
		if(!AutoApproval.isSelected())
		{
			AutoApproval.click();
		}{System.out.println("AutoApproval is already selected.");}
	}
	
	public void EmployeeCardManagement(String cardType, String regularCardNo, String cardExpiryDate) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased wait time
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    EmpCardManagement.click();
	    NewEmpFunctionCard.click();

	    // Handle Card Type Dropdown
	    safeClick(CardTypeDrop, js); // Safe click method with JS fallback

	    // Wait for the input element to be visible
	    WebElement searchCardInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//input[contains(@id,'s2id_autogen') and @type='text']")));

	    // Ensure the input is interactable and send keys
	    if (searchCardInput.isDisplayed() && searchCardInput.isEnabled()) {
	        searchCardInput.sendKeys(cardType);
	    } else {
	        System.out.println("Card type input is not interactable.");
	    }

	    // Handle dropdown options
	    Select dropdown = new Select(CardTypesOptions);
	    if (dropdown.getOptions().size() == 1) {
	        dropdown.selectByVisibleText(cardType);
	    }

	    // Handle Regular Card No Dropdown
	    safeClick(RegularCardNoDrop, js);
	    if (SearchRegularCard.isDisplayed()) {
	        SearchRegularCard.clear();
	        SearchRegularCard.sendKeys(regularCardNo);

	        for (WebElement card : CardNumbers) {
	            if (card.getText().equals(regularCardNo)) {
	                card.click();
	                break;
	            }
	        }
	    }

	    // Handle expiry date and save
	    CardExpiry.sendKeys(cardExpiryDate);
	    Save.click();
	}

	// Helper method for safe click
	private void safeClick(WebElement element, JavascriptExecutor js) {
	    try {
	        element.click();
	    } catch (ElementClickInterceptedException e) {
	        js.executeScript("arguments[0].click();", element);
	    }
	}


	
	public void Entity(String Entities)
	{
		Entity.click();
		NewEntity.click();
		
		EntitiesDrop.click();
		SearchEntity.sendKeys(Entities);
		
		for(WebElement selectEntity : EntityList)
		{
			if(selectEntity.getText().trim().equals(Entities))
			{
				selectEntity.click();
			}
		}
		SaveEntity.click();
	}
	
	public void Authentication(String AuthType)
	{
		NewEmpAuthentication.click();
		AuthDrop.click();
		SearchAuth.sendKeys(AuthType);
		for(WebElement selectAuth :AuthTypeList)
		{
			if(selectAuth.getText().trim().equals(AuthType)) 
			{
				selectAuth.click();
			}
		}

		SaveAuthType.click();
		
	}
	
	public void UserLoginDetails(String Password)
	{
		UserLoginDetailsTab.click();
		Pass.sendKeys(Password);
		
		logger.info("**** Finished all Test *****");
	}
	
///////--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
}
