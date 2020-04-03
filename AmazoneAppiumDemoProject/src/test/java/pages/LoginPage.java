package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.ReadWriteExcel;
import helper.CommonMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage {

    AndroidDriver<AndroidElement> driver;
    static Logger Log = LogManager.getLogger(LoginPage.class);  
    String[] userDetails;
    ReadWriteExcel readWriteExcel;
    CommonMethods commonMethods;
    
    @AndroidFindBy(id="chrome_action_bar_burger_icon")
    private AndroidElement menunOptions;    
     
    @AndroidFindBy(id="sign_in_button")
    private AndroidElement alreadyCustomerSignInButtton;
    
    @AndroidFindBy(id="login_accordion_header")
    private AndroidElement loginRadioButton;    
       
    @AndroidFindBy(className="android.widget.EditText")
    private AndroidElement emailText;
    
    @AndroidFindBy(className="android.widget.Button")
    private AndroidElement continueButton;    
    
    @AndroidFindBy(className="android.widget.EditText")
    private AndroidElement passwordText;    
    
    @AndroidFindBy(className="android.widget.Button")
    private AndroidElement signInButtton;
      
    @AndroidFindBy(xpath="//*[contains(@text,'Sign out')]")
    private AndroidElement signOutButton;
    
    @AndroidFindBy(xpath="//*[contains(@text,'Settings')]")
    private AndroidElement settingsOption;    
    
    @AndroidFindBy(xpath="//*[contains(@text,'SIGN OUT')]")
    private AndroidElement confirmSignOutButton;
    
    
    public LoginPage(AndroidDriver<AndroidElement> driver) 
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }   

    public HomePage Login() throws Exception {

        try {           

            readWriteExcel = new ReadWriteExcel();
            userDetails = readWriteExcel.ReadUserDetails(1);
            //String email = data.ReadExcel(1, 0);
            //String password = data.ReadExcel(1, 1);             
            commonMethods = new CommonMethods();
            
            commonMethods.ClickButton(alreadyCustomerSignInButtton, driver);              
            
            commonMethods.EnterText(userDetails[0], emailText);
           
            commonMethods.ClickButton(continueButton, driver);
            
            commonMethods.EnterText(userDetails[1], passwordText);
            
            commonMethods.ClickButton(signInButtton, driver);            
            Thread.sleep(3000); 
                        

        } catch (NoSuchElementException exception) {            

            Log.error("Login Failed " +exception.getMessage());
            Assert.fail();
        }
        
        HomePage homePage = new HomePage(driver);
        return homePage;

    }

    
    public LoginPage Logout() throws InterruptedException{       
        commonMethods = new CommonMethods();
        try {
            
            commonMethods.MenuOptionsButton(driver);
                        
            commonMethods.ScrollDown(driver);
            
            commonMethods.ClickButton(signOutButton, driver);
            
            commonMethods.ClickButton(confirmSignOutButton, driver);
           
            
        } catch (NoSuchElementException exception) {            
            Log.error("Logout Failed " +exception.getMessage());
        } 
        
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
    
    public boolean AlreadyCustomerSignInEnabled(){
        
        return alreadyCustomerSignInButtton.isEnabled();
    }
}
