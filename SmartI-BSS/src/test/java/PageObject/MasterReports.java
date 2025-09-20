package PageObject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReportsPageObject.BasePage;

public class MasterReports extends BasePage

{
	//Constructor
	public MasterReports(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locators
	@FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]") 
	WebElement AccessManagment;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[8]/a[1]") 
	WebElement Report;
	@FindBy(xpath="//body/div[@class='wrapper']/aside[@class='main-sidebar']/section[@class='sidebar']/div[@class='slimScrollDiv']/ul[@id='SidebarMenu']/li[@class='treeview active']/ul[@class='treeview-menu menu-open']/li[1]/a[1]") 
	WebElement Master;
	@FindBy(xpath="//a[@href='/Organization/Organization/OrganizationMaster']//span[contains(text(),'Organization')]")
	WebElement Organization;
	@FindBy(xpath="//b[@role='presentation']")
	WebElement LocDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]/*")
	List<WebElement> LocationList;
	@FindBy(xpath="//input[@id='s2id_autogen1_search']")
	WebElement SearchLoc;
	@FindBy(xpath="//div[@title='Refresh']//div[@class='button-outer']")
	WebElement Refreshbtn;
	@FindBy(xpath="//div[@title='Excel']//div[@class='button-outer']")
	WebElement Excelbtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']")
	WebElement PDFbtn;
	
	//Action Methods
	public void MasterOrgReport(String Location) throws InterruptedException
	{
		AccessManagment.click();
		Report.click();
		Master.click();
		Organization.click();
		
		//Refresh page
		
		LocDrop.click();	
		SearchLoc.sendKeys(Location);
		
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
		
		Thread.sleep(3000);
		
		Refreshbtn.click();
		
		Excelbtn.click();
		
		Thread.sleep(5000);
		
		PDFbtn.click();
		
		Thread.sleep(5000);
	}
	//public void 
	
}
