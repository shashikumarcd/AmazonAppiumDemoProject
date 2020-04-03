package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import components.ReadWriteExcel;
import helper.CommonMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    AndroidDriver<AndroidElement> driver;
    static Logger Log = LogManager.getLogger(HomePage.class);  
    ReadWriteExcel data;
    CommonMethods commonMethods;
    
    @AndroidFindBy(id="chrome_action_bar_burger_icon")
    private WebElement menunOptions;   
      
    @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
    public WebElement amazonHomeButton; 
    
    @AndroidFindBy(accessibility="Home")
    private WebElement homeButton;  
    
    @AndroidFindBy(xpath="//*[contains(@text,'Search')]")
    private AndroidElement searchProdcutText;
    
   @AndroidFindBy(xpath="//*[contains(@text,'Apple Iphone XR (128GB)')]")
    private AndroidElement prodcutTextView;    
        
    public HomePage(AndroidDriver<AndroidElement> driver) 
    {
     this.driver=driver;
     PageFactory.initElements(new AppiumFieldDecorator(driver), this);       
    }  
    
  
    public HomePage SearchProduct() throws Exception{
        
        try{
            
            commonMethods = new CommonMethods();
            
            commonMethods.SearchText("Apple Iphone XR (128GB) - Black", searchProdcutText, driver);
              
            //commonMethods.ClickButton(prodcutTextView, driver);
            //prodcutTextView.click();
            
            commonMethods.SearchProdcutByValue(prodcutTextView, "Apple Iphone XR (128GB) - Black",driver);
        
        
        }catch(NoSuchElementException exception){
            
            
        }
        
        HomePage homePage = new HomePage(driver);
        return homePage;
    }
    
    public boolean MenuOptionDisplayed()
    {    
        return menunOptions.isDisplayed();
    }
    
    public void HomeButton()
    {    
        amazonHomeButton.click();
    }
    public boolean HomeLabelEnabled()
    {    
        return homeButton.isEnabled();
    }
    
    public void FindElement(AndroidDriver<AndroidElement> driver)
     {   
        List<AndroidElement> elements = driver.findElements(By.className("android.widget.ImageView"));
        for(AndroidElement element : elements) 
        {
            if(element.getAttribute("contentDescription").equals("Home")) 
            {
                element.click(); 
                break;
            }
        }
   }
    
    public String HomeButtonText(AndroidDriver<AndroidElement> driver)
    {   
        String HomeButton="";
        List<AndroidElement> elements = driver.findElements(By.className("android.widget.ImageView"));
       for(MobileElement element : elements) 
       {           
           if(element.getAttribute("contentDescription").equals("Home")) 
           {
               HomeButton=element.getAttribute("contentDescription");               
               break;
           }
       }
       return HomeButton;
  }
    
    
    
    
}
