package MasterPage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BasePage;




public class DepartmentPage extends BasePage
{
	WebDriver driver;
	
	//Constrctor 
	public DepartmentPage(WebDriver driver)
	{
		super(driver);
	}

	//Locators
	@FindBy(xpath="//i[@class='nav-icon fa fa-th-list']") 
	WebElement Master;
	@FindBy(xpath ="//a[@href='/Master/Department']//span[contains(text(),'Department')]") 
	WebElement Department;
	@FindBy(xpath ="//p[contains(@class,'title-text')][contains(text(),'Access')]") 
	WebElement AccessManagement;
	@FindBy(xpath="//span[normalize-space()='New Department']") 
	WebElement NewDepartment;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog10_LocationMasterId']//b[@role='presentation']") 
	WebElement LocationDrp;
	@FindBy(xpath="//ul[@id='select2-results-2']/*") 
	List<WebElement> LocationOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog10_Division']//b[@role='presentation']") 
	WebElement DiviDrop;
	@FindBy(xpath = "//ul[@class='select2-results']/*")
	List<WebElement> DivisionOptions;
	@FindBy(name="DepartmentCode") 
	WebElement DepartCode;
	@FindBy(name ="DepartmentName") 
	WebElement DepartName;
	@FindBy(name ="AuditRemark") 
	WebElement AuditRmk;
	@FindBy(xpath ="//span[normalize-space()='Save']") 
	WebElement Savebtn;
	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-MessageDialog s-AlertDialog ui-dialog-buttons ui-draggable']")
	WebElement Alert;
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement Alertok;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BackArrow;
	
	
	
	
	//Edit Division
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") 
	WebElement SearchDivi;
	@FindBy(xpath="//div[@class='ui-widget-content slick-row even']//div[@class='slick-cell l3 r3']/a") 
	WebElement DeptName;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog28_LocationMasterId']//b[@role='presentation']")
	WebElement EditLocDrop; 
	@FindBy(xpath="#s2id_autogen2_search") 
	WebElement SearchDept;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List <WebElement> EditLocOptions;
	@FindBy (xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog19_Division']//b[@role='presentation']")
	WebElement EditDiviDrop;
	@FindBy(xpath="//ul[@class='select2-results']/*")
	List <WebElement> EditDiviOptions;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DepartmentDialog10_DepartmentCode']")
	WebElement EditDeprtC;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Master_DepartmentDialog10_DepartmentName']")
	WebElement EditDeptN;
	@FindBy(xpath="//div[@title='Apply Changes']//span[@class='button-inner']")
	WebElement saveApply;
	@FindBy(xpath="div[id='s2id_BuildingSolutionSuite_Master_DepartmentDialog82_LocationMasterId'] b[role='presentation']")
	WebElement EditLocation;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog19_LocationMasterId']//abbr[@class='select2-search-choice-close']")
	WebElement cross;
	@FindBy(xpath="//span[@id='select2-chosen-2']")
	WebElement EditLocationDrop;
	
	//ActionMethods.
	
	public void AddDepartment(String Location, String Division, String DepartmentCode, String DepartmentName, String AuditRemark ) throws InterruptedException
	{
		AccessManagement.click();
		Master.click();
		Department.click();	
		NewDepartment.click();
		LocationDrp.click();
		
		for(WebElement value : LocationOptions) 
		{
			if(value.getText().trim().equals(Location))
			{
				value.click();
				break;
			}
			
		}

		DiviDrop.click();
		//selectDivision(Division);
		for (WebElement divisionOption : DivisionOptions) {
            if (divisionOption.getText().trim().equals(Division)) {
                divisionOption.click();
                Thread.sleep(3000);
                break;
            }
        }
		DepartCode.sendKeys(DepartmentCode);
		DepartName.sendKeys(DepartmentName);
		AuditRmk.sendKeys(AuditRemark);
		Savebtn.click();
		System.out.println(Alert.getText());
		Alertok.click();
		BackArrow.click();
	}

	
	public void EditDepartment(String Divi, String EditLoc, String EditDivision, String Departcode, String DepartName ) throws InterruptedException
	{
		SearchDivi.sendKeys(Divi);
		Thread.sleep(3000);
		System.out.println(DeptName.getText());
		
		if(DeptName.getText().equals(Divi))
		{
			DeptName.click();
			Thread.sleep(0);
		}
		else
		{
			System.out.println("Department is not available");
		}
		
		//change information of department
		
		
		/*
		 * Editing location and division is not possible because xpath is changing everytime.
		//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog10_LocationMasterId']//span[@role='presentation']
		//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog19_LocationMasterId']//b[@role='presentation']
		//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog19_LocationMasterId']//b[@role='presentation']
		//span[@id='select2-chosen-4']
		//span[@id='select2-chosen-6']
		 
		
		//EditLocation.clear();
		//EditLocDrop.click();
		cross.click();
		//EditLocationDrop.click();
		EditLocDrop.click();
		SearchDept.sendKeys(EditLoc);
		for(WebElement SelectLoc:EditLocOptions)
		{
			if(SelectLoc.getText().trim().equals(EditLoc))
			{
				SelectLoc.click();
				Thread.sleep(3000);
				break;
			}
		}
		
		EditDiviDrop.click();
		//selectDivision(Division);
		for (WebElement EditdiviOption : EditDiviOptions) 
		{
            if (EditdiviOption.getText().trim().equals(EditDivision)) 
            {
            	EditdiviOption.click();
                Thread.sleep(3000);
                break;
            }
        } */
		
		EditDeprtC.sendKeys(Departcode);
		EditDeptN.sendKeys(DepartName);
		saveApply.click();
	}
	

}
