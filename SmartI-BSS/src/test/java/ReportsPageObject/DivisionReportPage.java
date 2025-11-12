package ReportsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DivisionReportPage extends BasePage{

	public DivisionReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//p[normalize-space()='Access']") WebElement AccessManagment;
	@FindBy(xpath="//span[normalize-space()='Reports']") WebElement Reports;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']//li[contains(@class,'treeview')]//a[@href='javascript:;']//span[contains(text(),'Master')]") WebElement Master;
	@FindBy(xpath="//a[@href='/Master/Division/DivisionMaster']//span[contains(text(),'Division')]") WebElement Division;
	@FindBy(xpath="//div[@title='Excel']//span[@class='button-inner']") WebElement Excelbtn;
	@FindBy(xpath="//div[@title='PDF']//span[@class='button-inner']") WebElement PDFbtn;
	@FindBy(xpath="//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']") WebElement Searchbar;
	@FindBy(xpath="//div[@class='slick-cell l2 r2']") WebElement SearchResultDiviN;
	@FindBy(xpath="//div[@class='slick-cell l1 r1']") WebElement SearchResultDiviC;
	
	//Action Methods
	public void InitialStep() {
		AccessManagment.click();
		Reports.click();
		Master.click();
		Division.click();
	}
	
	//TS0110 - Export to Excel
	public void ExportExcel() throws InterruptedException {
		InitialStep();
		Excelbtn.click();
		Thread.sleep(10000);
	}
	
	//TS0111 - Export to PDF
	public void ExportPDF() throws InterruptedException {
		InitialStep();
		PDFbtn.click();
		Thread.sleep(10000);
	}
	
	//TS0112 - Search Division by Code or Name
	public void VerifySearch(String DiviName, String DiviC) throws InterruptedException {

		InitialStep();
		Searchbar.sendKeys(DiviName);
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultDiviN.getText().contains(DiviName), "Search functionality failed");
		Searchbar.clear();
		Searchbar.sendKeys(DiviC);
		Thread.sleep(2000);
		Assert.assertTrue(SearchResultDiviC.isDisplayed(), "Searched Division is not displayed in the search result");
	}
}
