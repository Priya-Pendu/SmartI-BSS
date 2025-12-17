package ReportsPageObject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BasePage;
import Utilities.DropDownMethod;

public class OrganizationReportPage extends BasePage

{
	//Constructor
	public OrganizationReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") 
	WebElement AccessManagment;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[8]/a[1]") 
	WebElement Report;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[@class='treeview active']/ul[@class='treeview-menu menu-open']/li[1]/a[1]") 
	WebElement Master;
	@FindBy(xpath="//a[@href='/Organization/Organization/OrganizationMaster']//span[contains(text(),'Organization')]")
	WebElement Organization;
	@FindBy(xpath="//b[@role='presentation']")
	WebElement LocDrop;
	@FindBy(xpath="//div[@class=\"select2-result-label\"]")
	List<WebElement> LocationList;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']")
	WebElement SearchLoc;
	@FindBy(xpath="//div[@title='Refresh']//div[@class='button-outer']")
	WebElement Refreshbtn;
	@FindBy(xpath="//div[@title='Excel']//div[@class='button-outer']")
	WebElement Excelbtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']")
	WebElement PDFbtn;
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
	WebElement Searchbar;
	@FindBy(xpath="//div[@class='slick-cell l0 r0']")
	WebElement SearchResultOrg;
	@FindBy(xpath="//div[@class='slick-cell l2 r2']")
	WebElement SearchResultOrgCode;
	@FindBy(xpath="//div[@class=\"slick-cell l5 r5\"]")
	WebElement OrgLocfilter;
	DropDownMethod DM = new DropDownMethod();
	
	//Action Methods
	public void InitialStep()
	{
		AccessManagment.click();
		Report.click();
		Master.click();
		Organization.click();
	}

	//TS0090 - Search Organization by Keyword
	public void VerifySearchBar(String Org, String OrgCode) throws InterruptedException
	{
		InitialStep();
		Searchbar.sendKeys(Org);
		Thread.sleep(2000);
		if(SearchResultOrg.getText().contains(Org))
        {
            System.out.println("Search Functionality is working fine");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Search Functionality is not working");
        }
		
		Searchbar.clear();
		Searchbar.sendKeys(OrgCode);
		Thread.sleep(2000);
		if (SearchResultOrgCode.getText().contains(OrgCode)) {
			System.out.println("Search Functionality is working fine");
			Assert.assertTrue(true);
		} else {
			System.out.println("Search Functionality is not working");
		}
		
	}
	
	//TS0091 - Export Organization Report to Excel
	public void ExportExcel() throws InterruptedException
	{
		InitialStep();
		Excelbtn.click();	
		Thread.sleep(10000);
	}
	
	//TS0092 - Export Organization Report to PDF
	public void ExportPDF() throws InterruptedException {
		InitialStep();
		PDFbtn.click();
		Thread.sleep(10000);
	}
	
	/*public void VerifyLockationDrop(String Location) throws InterruptedException
	{
		InitialStep();
		LocDrop.click();	
		SearchLoc.sendKeys(Location);
		
		DM.selectFromDropdown(LocationList, "Mumbai", "Location");
		
		wait.until(ExpectedConditions.visibilityOfAllElements(LocationList));

		for(WebElement SelectLoc : LocationList)
		{
			System.out.println(SelectLoc.getText());
			if(SelectLoc.getText().equals(Location))
			{
				wait.until(ExpectedConditions.elementToBeClickable(SelectLoc));
				SelectLoc.click();
				break;
			}
		} 
		
	}*/
	
	public void VerifyLockationDrop(String Location) throws InterruptedException {
		InitialStep();
		// Click on location dropdown
		LocDrop.click();	
		SearchLoc.sendKeys(Location);
		Thread.sleep(3000);
		for (WebElement value : LocationList) {

			if (value.getText().trim().equals(Location)) {
				value.click();
				Thread.sleep(3000);
				if(OrgLocfilter.getText().equals(Location));
				{
					System.out.println("Location filter is applied successfully");
				}
				break;
			} else {
				System.out.println("The given location is not matched");
			}
		}

	}

	
}
