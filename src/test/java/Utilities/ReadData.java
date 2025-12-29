package Utilities;

import org.openqa.selenium.WebElement;

public class ReadData {


	    // Safe read for input fields
	    public static String readValue(WebElement element) {
	        if (element == null) {
	            return "null";
	        }
	        String value = element.getAttribute("value");
	        return (value == null || value.trim().isEmpty()) ? "null" : value.trim();
	    }

	    // Safe read for text fields / dropdowns
	    public static String readText(WebElement element) {
	        if (element == null) {
	            return "null";
	        }
	        String text = element.getText();
	        return (text == null || text.trim().isEmpty()) ? "null" : text.trim();
	    }
	}



