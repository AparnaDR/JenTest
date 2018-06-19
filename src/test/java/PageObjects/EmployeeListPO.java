package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class EmployeeListPO {

	WebDriver driver;

	@FindBy( id = "menu_pim_viewPimModule")
	WebElement Pim;

	@FindBy( id = "menu_pim_viewEmployeeList")
	WebElement empListTab;

	@FindBy( id = "empsearch_employee_name_empName")
	WebElement fistName;

	@FindBy ( xpath = "//div[@class = 'ac_results']//li[1]/strong")
	WebElement clickFromDropDown;

	@FindBy( id = "searchBtn")
	WebElement searchButton;


	public EmployeeListPO(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void clickPIM(){
		Pim.click();

	}

	public void clickEmployeeList(){

		empListTab.click();
	}

	public void clearFirstName(){
		this.fistName.clear();
	}

	public void enterFirstName(String firstName)
	{
		this.fistName.sendKeys(firstName);
	}

	public void selectFirstName(){
		clickFromDropDown.click();
	}

	public void clickOnSearch(){
		searchButton.click();
	}

	public void verifyNewlyAddedEmployee(String firstName) throws Exception
	{
		this.clickPIM();
		this.clickEmployeeList();
		Thread.sleep(2000);
		this.clearFirstName();
		this.enterFirstName(firstName);
		Thread.sleep(6000);
		System.out.println("Entered firstnsme");
		this.selectFirstName();
		Thread.sleep(6000);
		this.clickOnSearch();
		System.out.println("clicked on search");
		Thread.sleep(2000);
		verifyEmployeIsPresent(firstName);

	}

	public  void verifyEmployeIsPresent(String firstName)
	{
		WebElement row = driver.findElement(By.xpath("//*[@id='resultTable']/tbody"));
		List<WebElement> rows = row.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		//List<WebElement> cols = driver.findElements(By.xpath(".//*[@id='post-31777']/div[1]/div[2]/div/div/div[1]/div/table[1]/tbody/tr/td"));

		for(int i=0; i<rows.size(); i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=1; j<=3;j++)
			{
				String str = cols.get(j).getText();
				System.out.println(str);
				
				if(str.contains("Aparna")){	
					System.out.println("inside if");
					Assert.assertEquals(str,"Aparna","PASS if found");
					
				}
			}	


		}
		
		
	}
}