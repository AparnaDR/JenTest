package learning;

import java.util.concurrent.TimeUnit;

import listener.Retry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import util.ReadExcel;
import PageObjects.EmployeeListPO;
import PageObjects.LoginPO;
import PageObjects.PimPO;

public class TestClass {
	
	private static Logger Log = Logger.getLogger(TestClass.class);//
	
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
		Log.info("URL launched");
		
	}

	@Test(priority = 1, retryAnalyzer = Retry.class ,dataProvider = "LoginDP" , dataProviderClass = ReadExcel.class)

	public void test_Home_Page_Appear_Correct(String uid, String pwd) {

		// Create Login Page object

		loginObj = new LoginPO(driver);

		// login to application

		loginObj.loginToApplication(uid,pwd);

		loginObj.AsertLogin("Welcome Admin");
		
		System.out.println("Login TC completed after assert");
		Log.info("Login TC comp");

	}

//	@Test(priority = 2, retryAnalyzer = Retry.class,dataProvider="AddEmp",dataProviderClass = ReadExcel.class)

	public void addNewEMployee(String uid, String pwd , String fn, String ln) throws InterruptedException {

		test_Home_Page_Appear_Correct(uid, pwd);
		addEmp = new PimPO(driver);
		addEmp.AddNewEmployee(fn,ln);
		System.out.println("Added new Employee: "+fn +ln);
		Log.info("Added Employeee: "+ fn + ln);

	}

	//@Test(priority = 3, retryAnalyzer = Retry.class)

	public void verifyEmp() throws Exception {

		//test_Home_Page_Appear_Correct();
		verifyEmp = new EmployeeListPO(driver);
		verifyEmp.verifyNewlyAddedEmployee("Aparna DR");

	}

	@AfterMethod

	public void close() {
		driver.close();
		Log.info("CLosing the browser");
	}

}
