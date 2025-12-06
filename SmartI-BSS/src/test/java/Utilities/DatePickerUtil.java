package Utilities;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	public class DatePickerUtil {

	    /**
	     * Selects a date from a date picker.
	     *
	     * @param driver  WebDriver instance
	     * @param datePickerInputLocator Locator for the input field that opens the date picker
	     * @param day     Day to select (e.g., 16)
	     * @param month   Month to select (e.g., "Jan" or "January")
	     * @param year    Year to select (e.g., 2025)
	     */
	    public static void selectDate(WebDriver driver, By datePickerInputLocator, 
	                                  String day, String month, String year) {
	        // Click input box to open the date picker
	        driver.findElement(datePickerInputLocator).click();

	        // Select month
	        WebElement monthDropdown = driver.findElement(By.xpath("//select[contains(@class,'ui-datepicker-month') or contains(@aria-label,'month')]"));
	        Select selectMonth = new Select(monthDropdown);
	        selectMonth.selectByVisibleText(month);

	        // Select year
	        WebElement yearDropdown = driver.findElement(By.xpath("//select[contains(@class,'ui-datepicker-year') or contains(@aria-label,'year')]"));
	        Select selectYear = new Select(yearDropdown);
	        selectYear.selectByVisibleText(year);

	        // Select day
	        WebElement dayElement = driver.findElement(By.xpath("//table//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='" + day + "']"));
	        dayElement.click();
	    }
	}


