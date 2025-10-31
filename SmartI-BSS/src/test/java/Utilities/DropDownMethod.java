package Utilities;

	 
import java.util.List;
 
import org.openqa.selenium.WebElement;
 
public class DropDownMethod {
 
	public void selectFromDropdown(List<WebElement> options, String valueToSelect, String fieldName) {
   boolean found = false;
 
	    for (WebElement option : options) {
       if (option.getText().trim().equalsIgnoreCase(valueToSelect)) {
           option.click();
           //logger.info(fieldName + " selected: " + valueToSelect);
           found = true;
           break;
       }
   }
 
	    if (!found) {
       //logger.warn("No matching value found in " + fieldName + " dropdown for: " + valueToSelect);
   	System.out.println("No matching value found in " + fieldName + " dropdown for: " + valueToSelect);
	   }
		}
	 
	}

