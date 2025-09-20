package PageObject;

import org.apache.logging.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public Logger logger;  //log 4j

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePage(WebDriver driver) 
    {	
    	logger = LogManager.getLogger(this.getClass());
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Use the new constructor
        PageFactory.initElements(driver, this);  // Initialize PageFactory elements
    }
}
