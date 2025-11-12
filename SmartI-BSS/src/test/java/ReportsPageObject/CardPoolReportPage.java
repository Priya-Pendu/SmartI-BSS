package ReportsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.DropDownMethod;

public class CardPoolReportPage extends BasePage {

	
	public CardPoolReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='CardPool']") WebElement CardPool;
	@FindBy(xpath="//div[@id='s2id_BuildingSolutionSuite_Default_ViewAccessCardPoolGrid0_QuickFilter_LocationMasterId']//b[@role='presentation']") WebElement LocDrop;
	@FindBy(xpath="//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]") List<WebElement> LocationOptions;
	@FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]") WebElement LocationResult;
	DropDownMethod DD = new DropDownMethod();
	
	//Action Method
	public void Initialstep()
	{
		AccessManagment.click();
		Reports.click();
		Master.click();
		CardPool.click();
	}
	
	//TS0118 - Location Filter Validation
	public void LocationFilterValidation() throws InterruptedException {
		Initialstep();
		LocDrop.click();
		Thread.sleep(2000);
		DD.selectFromDropdown(LocationOptions, "Kalyan", "Location");
		Thread.sleep(2000);
		Assert.assertTrue(LocationResult.getText().contains("Kalyan"), "Location filter is not working as expected");
	}
	
	
	
}
