package Utilities;

import org.openqa.selenium.WebElement;

public class MaxCharacterLenght {

	public static int getMaxInputLength(WebElement field, String inputUnit, int stepLength) {
	    field.clear();
	    int count = 0;
	    StringBuilder buffer = new StringBuilder();

	    while (true) {
	        String chunk = inputUnit.repeat(stepLength);
	        buffer.append(chunk);
	        field.sendKeys(chunk);

	        String currentValue = field.getAttribute("value");
	        if (currentValue.length() == buffer.length()) {
	            count += chunk.length();
	        } else {
	            break;
	        }
	    }

	    
	    return count;
	}



}
