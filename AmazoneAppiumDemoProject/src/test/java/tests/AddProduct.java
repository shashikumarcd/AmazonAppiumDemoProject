package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class AddProduct extends BaseClass {
  
  static Logger Log = LogManager.getLogger(LoginLogout.class);
  ExtentTest TestLog; 
  @Test
  public void SearchProduct() throws Exception {     
      TestLog=extent.createTest(getClass().getEnclosingClass().getName(), "Add Product");
      TestLog.log(Status.INFO, "*** Add Prodcut Test Started ***");
      Log.info("Add Product Test Started");
      LoginPage loginPage = new LoginPage(driver);        
      HomePage homePage = loginPage.Login();
      
      homePage.SearchProduct();
      
      Log.info("Add Prodcut Test Completed");
      TestLog.log(Status.INFO, "*** Add Prodcut Test Started ***");
  }
  
  
}
