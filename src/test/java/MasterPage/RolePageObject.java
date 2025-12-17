package MasterPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;

public class RolePageObject extends BasePage
{
    // Constructor
    public RolePageObject(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]") 
    WebElement AccessManagement;
    @FindBy(xpath="//span[normalize-space()='Administration']")
    WebElement Administration;
    @FindBy(xpath="//span[normalize-space()='Role']")
    WebElement Role;
    @FindBy(xpath="//span[normalize-space()='New Role']")
    WebElement NewRole;
    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Administration-RoleDialog s-Administration-RoleDialog s-RoleDialog ui-draggable ui-resizable flex-layout']")
    WebElement RoleDialogBox;	
    @FindBy(name="RoleName")
    WebElement RoleName;
    @FindBy(xpath="//span[normalize-space()='Save']")
    WebElement save;

    // Edit Role
    @FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']")
    WebElement EditSearch; 
    @FindBy(xpath="//div[@class='slick-cell l1 r1']/a")
    WebElement SelectRole;
    @FindBy(name="RoleName")
    WebElement EditRoleName;
    @FindBy(xpath="//span[normalize-space()='Edit Permissions']")
    WebElement EditRolePermission;
    @FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front s-Dialog s-BuildingSolutionSuite-Administration-RolePermissionDialog s-Administration-RolePermissionDialog s-RolePermissionDialog ui-dialog-buttons ui-draggable ui-resizable flex-layout']")
    WebElement EditRoleBox;
    @FindBy(xpath="//div[@class=\"slick-cell l1 r1 align-center\"]/*")
    List<WebElement> AllCheckBox;
    @FindBy(xpath="//button[normalize-space()='OK']")
    WebElement EditPermissionOK;
    @FindBy(xpath="//div[@class=\"ui-widget-content slick-row even\"]/*")
    List<WebElement> PermissionsName; 

    // Action Methods
    public void AddRole(String RoleN) throws InterruptedException {
        AccessManagement.click();
        Administration.click();
        Role.click();
        NewRole.click();
        
        System.out.println(RoleDialogBox.getText());
        RoleName.sendKeys(RoleN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(save)).click(); // Wait and click save
    }

    public void EditRole(String RoleName, String NewRoleN) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        EditSearch.clear();
        EditSearch.sendKeys(RoleName);

        wait.until(ExpectedConditions.textToBePresentInElement(SelectRole, RoleName));
        
        if (SelectRole.isDisplayed() && SelectRole.getText().equals(RoleName)) {
            SelectRole.click();
        } else {
            System.out.println("Role Name does not match");
        }
        
        EditRoleName.clear();
        EditRoleName.sendKeys(NewRoleN);
        EditRolePermission.click();
        wait.until(ExpectedConditions.visibilityOf(EditRoleBox)); // Wait for the role permission dialog to show
        
        // Loop through checkboxes
        for (int i = 0; i < AllCheckBox.size(); i++) {
            WebElement CheckBox = AllCheckBox.get(i);

            try {
                // Scroll the checkbox into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CheckBox);

                // Wait for the checkbox to be clickable again (re-find it)
                WebElement clickableCheckbox = wait.until(ExpectedConditions.elementToBeClickable(CheckBox));

                // Click the checkbox if not already selected
                if (!clickableCheckbox.isSelected()) {
                    clickableCheckbox.click();
                    System.out.println("All permissions are granted.");
                } else {
                    System.out.println("Checkbox is already selected.");
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected, re-locating the element.");
                // Re-locate the checkbox if it becomes stale and try again
                CheckBox = driver.findElements(By.xpath("//div[@class=\"slick-cell l1 r1 align-center\"]/*")).get(i);
                CheckBox.click();
            }
        }
        
        // Wait and click OK to save the permissions
        wait.until(ExpectedConditions.elementToBeClickable(EditPermissionOK)).click();
    }
}
