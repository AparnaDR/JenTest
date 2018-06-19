package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPO {
	
	WebDriver driver;
	
	@FindBy(name="txtUsername")

    WebElement userName;

    

    @FindBy(name="txtPassword")

    WebElement password;


    @FindBy(name="Submit")

    WebElement login;

    @FindBy(id = "welcome")
    
    WebElement welcome;
    

    public LoginPO(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        userName.sendKeys(strUserName);

        }
    
   
    	
    

    //Set password in password textbox

    public void setPassword(String strPassword){

    password.sendKeys(strPassword);

    }

    

    //Click on login button

    public void clickLogin(){

            login.click();

    }
    
    public void AsertLogin(String msg)
    {
    	Assert.assertEquals(welcome.getText(), msg , "Not Logged In");
    }

    

   

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToApplication(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();

                

    }

}	

