package ReportsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BasePage;

public class TransactionalAccessPage extends BasePage {

	public TransactionalAccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
}
