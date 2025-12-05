package ReportsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeEntityAccessPage extends BasePage
{

	public EmployeeEntityAccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//span[normalize-space()='Employee Entity Access']") WebElement EmployeeEntityAccess;
	
	//ActionMethods
	public void InitialSteps() {
		AccessManagment.click();
		Reports.click();
		Master.click();
		EmployeeEntityAccess.click();
	}
}
