package MasterPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BasePage;

public class DashboardPage extends BasePage
{
	//Constructor
	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//p[@class='title-text'][contains(text(),'Access')]")
	WebElement AccessManagement;
	@FindBy(xpath="//a[@href='/Employee/EmployeeMaster'][normalize-space()='More info']")
	WebElement InActiveEmpBtn ;
	@FindBy(xpath="//h3[normalize-space()='6']")
	WebElement InternalEmployeeCount ;
	@FindBy(xpath="//div[@class=\"slick-cell l0 r0\"]/a")
	List <WebElement> Employeecode;
	@FindBy(xpath="//div[@class='small-box bg-green']//a[@class='small-box-footer'][normalize-space()='More info']")
	WebElement CriticalEvent;
	@FindBy(xpath="//span[normalize-space()='Dashboard']")
	WebElement Dashboard;
	@FindBy(xpath="//div[@class='small-box bg-yellow']//h3[contains(text(),'0')]")
	WebElement EmployeeInCount;
	@FindBy(xpath="//div[@class='small-box bg-yellow']//a[@class='small-box-footer'][normalize-space()='More info']")
	WebElement EmployeeInbtn;
	@FindBy(xpath="//div[@class='small-box bg-red']//h3[contains(text(),'0')]")
	WebElement TailgatingC ;
	@FindBy(xpath="//div[@class='small-box bg-red']//a[@class='small-box-footer'][normalize-space()='More info']")
	WebElement Tailgatingbtn;
	@FindBy(xpath="//div[@class='box box-solid bg-teal-gradient']//button[1]")
	WebElement UHAminimize;
	@FindBy(xpath="//button[@class='btn btn-success btn-sm pull-right']")
	WebElement T5MADMinimize;
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm pull-right']")
	WebElement EventSAMin;
	
	//Action Methods
	public void InActiveEmp()
	{
		AccessManagement.click();
		String EmployeeCountText = InternalEmployeeCount.getText();
	
		InActiveEmpBtn.click();
		
		int Empcount= Employeecode.size();
		
		 
		if(EmployeeCountText.equals(String.valueOf(Empcount))) 
		{
			System.out.println("Dashboard displaying correct info");
		} 
		else
		{
		    System.out.println("Dashboard displaying incorrect info");
		}
	}
	
	public void CriticalEvent()
	{
		Dashboard.click();
		
		String CriticalEventCount = CriticalEvent.getText();
		
		int Count = 0;
		
		CriticalEvent.click();
		
		if(CriticalEventCount.equals(String.valueOf(Count)))
		{
			System.out.println("There is no critical event available");
		}
		
		
	}
	
	public void EmployeeIN()
	{
		Dashboard.click();
		
		String EmoInCount = EmployeeInCount.getText();
		
		int Count = 0;
		
		EmployeeInbtn.click();
		
	}
	
	public void Tailgatingcount()
	{
		Dashboard.click();
		
		String TailCount = TailgatingC.getText();
		
		int Count = 0;
		
		Tailgatingbtn.click();
	}
	
	public void UHAccess()
	{
		Dashboard.click();
		UHAminimize.click();
	}
	
	public void Top5MAD()
	{
		T5MADMinimize.click();
	}
	
	public void EventSA()
	{
		EventSAMin.click();
		EventSAMin.click();
	}
}
