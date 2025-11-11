package Utilities;
	 
	import java.time.Duration;

	import org.openqa.selenium.*;

	import org.openqa.selenium.support.ui.*;

public class DateUtil {
	
	 
	
	 
	    /**

	     * Selects a date from a jQuery UI DatePicker based on a dynamic calendar icon locator.

	     *

	     * @param driver      WebDriver instance

	     * @param calendarBy  By locator of the calendar icon (img)

	     * @param year        Full year (e.g., "2025")

	     * @param month       Full month name (e.g., "September")

	     * @param day         Day of month (e.g., "25")

	     */

		public static String selectDate(WebDriver driver, By calendarBy, String year, String month, String day) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
		    // Click calendar

		    wait.until(ExpectedConditions.elementToBeClickable(calendarBy)).click();
	 
		    // Select year

		    Select yearSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(

		        By.xpath("//select[@class='ui-datepicker-year']"))));

		    yearSelect.selectByVisibleText(year);
	 
		    // Select month

		    Select monthSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(

		        By.xpath("//select[@class='ui-datepicker-month']"))));

		    monthSelect.selectByVisibleText(month);
	 
		    // Select day

		    WebElement dayCell = wait.until(ExpectedConditions.elementToBeClickable(

		        By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']")));

		    dayCell.click();
	 
		    String selectedDate = day + "-" + month + "-" + year;

		    System.out.println("✅ Date selected: " + selectedDate);

		    return selectedDate;

		}
	 
	}
	 

