package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPO {
	
	WebDriver driver;
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIM;
	
	@FindBy( id = "menu_pim_viewEmployeeList")
	WebElement empListTab;
	
	@FindBy(id = "btnAdd")
	WebElement addButton;
	
	@FindBy( id ="firstName")
	WebElement firstName;
	
	@FindBy( id ="lastName")
	WebElement lastName;
	
	@FindBy( id= "btnSave")
	WebElement save;
	
	public PimPO (WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPIM(){
		PIM.click();
	}
	
	public void clickEmployeeList(){
		empListTab.click();
	}
	
	public void clickAddButton(){
		addButton.click();
	}
	
	public void enterFirstName(String firstName){
		this.firstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		this.lastName.sendKeys(lastName);
	}
	
	public void clickSave()
	{
		save.click();
	}
	
	public void AddNewEmployee(String firstName, String lastName) throws InterruptedException{
		
		this.clickPIM();
		clickEmployeeList();
		Thread.sleep(3000);
		this.clickAddButton();
		this.enterFirstName(firstName);
		this.enterLastName(lastName);
		this.clickSave();
		
		
	}
	
}
