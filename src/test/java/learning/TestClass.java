package learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.EmployeeListPO;
import PageObjects.LoginPO;
import PageObjects.PimPO;
import listener.Retry;

public class TestClass {

	WebDriver driver;
	LoginPO loginObj;
	PimPO addEmp;
	EmployeeListPO verifyEmp;

	@BeforeMethod(alwaysRun = true)

	public void setup() {

		// System.setProperty("webdriver.gecko.driver", value)

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://opensource.demo.orangehrmlive.com/");

	}

	@Test(priority = 1, retryAnalyzer = Retry.class)

	public void test_Home_Page_Appear_Correct() {

		// Create Login Page object

		loginObj = new LoginPO(driver);

		// login to application

		loginObj.loginToApplication("admin", "admin");

		loginObj.AsertLogin("Welcome Admin");

		System.out.println("Login TC completed after assert");

	}

//	@Test(priority = 2, retryAnalyzer = Retry.class)

	public void addNewEMployee() throws InterruptedException {

		test_Home_Page_Appear_Correct();
		addEmp = new PimPO(driver);
		addEmp.AddNewEmployee("Aparna", "DR");
		System.out.println("Added new Employee");

	}

	//@Test(priority = 3, retryAnalyzer = Retry.class)

	public void verifyEmp() throws Exception {

		test_Home_Page_Appear_Correct();
		verifyEmp = new EmployeeListPO(driver);
		verifyEmp.verifyNewlyAddedEmployee("Aparna DR");

	}

	@AfterMethod

	public void close() {
		driver.close();
	}

}
