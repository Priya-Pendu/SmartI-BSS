package AdministrationPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utilities.BasePage;

public class RolesPage extends BasePage {

	public RolesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Administration']") WebElement Administration;
	@FindBy(xpath="//span[normalize-space()='Role']") WebElement Role;
	@FindBy(xpath="//span[normalize-space()='New Role']") WebElement NewRole;
	@FindBy(xpath="//input[@id='BuildingSolutionSuite_Administration_RoleDialog8_RoleName']") WebElement RoleName;
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement SaveBtn;
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement RoleSearchBar;
	@FindBy(xpath="//div[@class=\"slick-cell l1 r1\"]/a") WebElement RoleResult;
	@FindBy(xpath="//span[@id='ui-id-1']") WebElement RoleForm;
	
	//ActionMethods
	public void InitialSteps() throws InterruptedException {
		AccessManagment.click();
		Administration.click();
		Role.click();
	}
	
	//TS0191 - Add New Role
	public void AddNewRole(String RoleN) throws InterruptedException {
		InitialSteps();
		NewRole.click();
		RoleName.sendKeys(RoleN);
		SaveBtn.click();
		Assert.assertTrue(NewRole.isDisplayed(), "New Role not added successfully");
	}
	
	//TS0192 - View Roles Form
	public void ViewRolesForm(String RoleN) throws InterruptedException {
		InitialSteps();
		RoleSearchBar.sendKeys(RoleN);
		RoleResult.click();
	    Assert.assertTrue(RoleForm.isDisplayed(), "Roles Form not opened successfully");
	}
	
	//TS0193 - Update Roles Data
	public void UpdateRolesData(String RoleN, String NewRoleN) throws InterruptedException {
		InitialSteps();
		RoleSearchBar.sendKeys(RoleN);
		RoleResult.click();
		wait.until(ExpectedConditions.visibilityOf(RoleForm));
		RoleName.clear();
		RoleName.sendKeys(NewRoleN);
		SaveBtn.click();
		Thread.sleep(2000);
		logger.info("Role updated successfully");
		ViewRolesForm(RoleN);
	}
	
}
