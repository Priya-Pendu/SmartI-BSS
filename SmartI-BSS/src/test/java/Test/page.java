package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.BasePage;

public class page extends BasePage{
WebDriver driver;
	
	//Constrctor 
	public page(WebDriver driver)
	{
		super(driver);
	}
	

	
	public void setup(String string, String string2) throws InterruptedException
	{
		
	driver.get("https://www.latlong.net/Show-Latitude-Longitude.html");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='latitude']")).sendKeys("latitude");
	driver.findElement(By.xpath("//input[@id='longitude']")).sendKeys("longitude");
	driver.findElement(By.xpath("//button[normalize-space()='Convert']")).click();
	Thread.sleep(2000);
	String value = driver.findElement(By.xpath("//div[@id='address']")).getText();
	
    System.out.println("Address is: " + value);
    
	}
	
}
