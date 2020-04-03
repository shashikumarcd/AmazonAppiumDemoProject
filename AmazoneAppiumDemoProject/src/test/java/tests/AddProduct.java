package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class AddProduct extends BaseClass {
  
  static Logger Log = LogManager.getLogger(LoginLogout.class);
  @Test
  public void SearchProduct() throws Exception {     
      
      Log.info("Search Test Started");
      LoginPage loginPage = new LoginPage(driver);        
      HomePage homePage = loginPage.Login();
      
      homePage.SearchProduct();
      
      Log.info("Search Test Completed");
  }
  
  
}
