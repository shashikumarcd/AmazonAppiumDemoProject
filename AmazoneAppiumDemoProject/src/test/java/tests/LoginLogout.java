package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;


public class LoginLogout extends BaseClass {

    ExtentTest TestLog; 
    static Logger Log = LogManager.getLogger(LoginLogout.class);  
    @Test
    public void LoginTest() throws Exception {
        
            TestLog=extent.createTest(getClass().getEnclosingClass().getName(), "Login & Logout");
       
            TestLog.log(Status.INFO, "*** Login Test Started ***");
            Log.info("Login Test Started");
            LoginPage loginPage = new LoginPage(driver);        
            HomePage homePage = loginPage.Login();  
            
            SoftAssert assrt = new SoftAssert();            
            assrt.assertEquals("Home", homePage.HomeButtonText(driver));
            
            
            TestLog.log(Status.INFO, "Successfully Logged into Amazon"); 
            Log.info("Successfully Logged into Amazon"); 

            TestLog.log(Status.INFO, "*** LogOut Test Started ***");
            Log.info("Logout Test Started");
            loginPage.Logout();
            assrt.assertTrue(loginPage.AlreadyCustomerSignInEnabled());
            TestLog.log(Status.INFO, "*** Successfully Logged out from Amazon *** "); 
            Log.info("Successfully Logged out from Amazon"); 
            
    } 
    
    
}
