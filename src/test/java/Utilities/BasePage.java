package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    // Constructor does not need driver
    public BasePage(WebDriver driver) {
    	 this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         this.logger = LogManager.getLogger(this.getClass());
         PageFactory.initElements(driver, this);  // initialize @FindBy
    }

    
}

