package MasterPage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;




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
	WebElement SearchDepart;
	@FindBy(xpath="//div[@class=\"slick-cell l3 r3\"]/a") 
	List<WebElement> DepartmentOptions;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog10_LocationMasterId']//b[@role='presentation']")
	WebElement EditLocDrop; 
	@FindBy(xpath="#s2id_autogen2_search") 
	WebElement SearchDept;
	@FindBy(xpath="//ul[@class=\"select2-results\"]/*")
	List <WebElement> EditLocOptions;
	@FindBy (xpath="//div[@id='s2id_BuildingSolutionSuite_Master_DepartmentDialog10_Division']//b[@role='presentation']")
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
	@FindBy(xpath="//input[@id='s2id_autogen2_search']")
	WebElement SearchLoc;
	@FindBy(xpath ="//span[@id='select2-chosen-2']")
	WebElement SelectedLoc;
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	WebElement SelectedDiv;
	@FindBy(xpath="//button[@class='panel-titlebar-close']")
	WebElement BacktoDeptList;
	@FindBy(xpath="//input[@id='s2id_autogen3_search']")
	WebElement SearchDiv;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']")
	WebElement ExcelExport;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']")
	WebElement pdfExport;
	DropDownMethod ddm = new DropDownMethod();
	//ActionMethods.
	
	public void InitialStep()
	{
		AccessManagement.click();
		Master.click();
		Department.click();
	}
	
	//TS0039 - Fill Department Details
	public void AddDepartment(String Location, String Division, String DepartmentCode, String DepartmentName, String AuditRemark ) throws InterruptedException
	{
		InitialStep();
		NewDepartment.click();
		LocationDrp.click();
		SearchLoc.sendKeys(Location);
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
		Assert.assertTrue(NewDepartment.isDisplayed(), "New Department page is not displayed after saving department.");
	}

	//TS0040 - View an existing Department
	public void ViewExistDepa(String DeptN) throws InterruptedException
	{
		InitialStep();
		SearchDepart.sendKeys(DeptN);
		Thread.sleep(3000); 
		
		for (WebElement dept : DepartmentOptions) {
			if (dept.getText().trim().equals(DeptN)) {
				dept.click();
				Thread.sleep(2000);
				System.out.println("Department details are as : " +"+\n"+"Location : "+ SelectedLoc.getText() + "," +"\n"
				        + "Division : " + SelectedDiv.getText() + "," + "\n"
						 +"Department Code : "+ DepartCode.getAttribute("value") + "," + "\n"
						+ "DepartmentName"+DepartName.getAttribute("value"));
				BacktoDeptList.click();
				break;
			}
		}
		Assert.assertTrue(NewDepartment.isDisplayed());
	}
	
	
	//TS0041 - Edit an existing Department
	public void EditDepartment(String DeptN, String EditLoc, String EditDivision, String Departcode, String DepartName ) throws InterruptedException
	{
		InitialStep();
		SearchDepart.sendKeys(DeptN);
		Thread.sleep(3000); 
		
		for (WebElement dept : DepartmentOptions) {
			if (dept.getText().trim().equals(DeptN)) {
				dept.click();
				Thread.sleep(2000);
				//Select Location
				EditLocDrop.click();
				SearchLoc.sendKeys(EditLoc);
				ddm.selectFromDropdown(EditLocOptions, EditLoc, "Location");
				
				//Select Division
				EditDiviDrop.click();
				SearchDiv.sendKeys(EditDivision);
				ddm.selectFromDropdown(EditDiviOptions, EditDivision, "Division");
				//Edit Department Code and Name
				EditDeprtC.clear();
				EditDeprtC.sendKeys(Departcode);
				EditDeptN.clear();
				EditDeptN.sendKeys(DepartName);
				saveApply.click();
				Thread.sleep(2000);
				BacktoDeptList.click();
				break;
			}
		}
		Assert.assertTrue(NewDepartment.isDisplayed());
	
	} 
	

	//TS0042 - Export Department list to Excel
	public void ExportExcel() throws InterruptedException {
		InitialStep();
		ExcelExport.click();
		Thread.sleep(10000);
	}
	
	//TS0043 - Export Department list to PDF
	public void ExportPDF() throws InterruptedException {
		InitialStep();
		pdfExport.click();
		Thread.sleep(10000);
	}
	
}
