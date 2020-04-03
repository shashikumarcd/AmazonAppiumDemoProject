package helper;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CommonMethods {

    //protected WebDriverWait wait;


    //    public CommonMethods(AppiumDriver<MobileElement> driver) {
    //        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    //    } 

    public void implicitwait(AndroidElement element ) {

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void explicitwait(WebElement element,AppiumDriver<AndroidElement> driver) {

        /*wait = new WebDriverWait(driver, 30);  

        //        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("")),
        //                                         ExpectedConditions.presenceOfElementLocated(By.id(""))));

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));*/

    }

    public void switchToNewWindow(AppiumDriver<AndroidElement> driver) {  

        try {
            Set<String> windows = driver.getWindowHandles();
            ((JavascriptExecutor) driver).executeScript("window.open();");
            Set<String> newwindow = driver.getWindowHandles();
            newwindow.removeAll(windows);
            String newhandle = ((String) newwindow.toArray()[0]);
            driver.switchTo().window(newhandle);
        } catch (Exception e) {
            // TODO: handle exception
        }       


    }

    public void clickWebelement(AndroidElement element,AppiumDriver<AndroidElement> driver) {

        try {

            //wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementNotVisibleException exception) {

            //            JavascriptExecutor executor = (JavascriptExecutor)driver;
            //            executor.executeScript("arguments[0].click(", element);
        }
    }

    public void EnterText(String value, AndroidElement element) {
        try {
            if(element.isDisplayed()) {                
                element.clear();            
                element.sendKeys(value);
            }
            else 
            {
                Assert.fail();
            }            

        } catch (Exception exc) {

            exc.getMessage();
        }
    }
    
    public void SearchText(String value, AndroidElement element, AndroidDriver<AndroidElement> driver) {
        try {
            if(element.isDisplayed()) {                
                element.click();
                element.clear();                
                element.sendKeys(value);
                driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            }
            else 
            {
                Assert.fail();
            }            

        } catch (Exception exc) {

            exc.getMessage();
        }
    }
    
    
    

    public void ClickButton(AndroidElement element, AppiumDriver<AndroidElement> driver) {
        
        WebDriverWait wait = new WebDriverWait(driver, 30);  
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if(element.isDisplayed())
        {
            element.click();
        }
        else
        {
            Assert.fail();
        }

    }
            
    public void SelectDropdownOption(AndroidElement element, String selectoption, AppiumDriver<AndroidElement> driver, String str) throws InterruptedException {

        element.click();
        Thread.sleep(1000);
       
        List<AndroidElement> options = driver.findElements(By.id(selectoption));  
        //log.info("Number of list found = "+options.size());
        
        for(int i=0; i<options.size();i++) {
            if(options.get(i).getText().contains(str)) {
                driver.navigate().back();
                options.get(i).click();
                // log.info("Option selected = "+options.get(i).getText());
                break;
            }           
        }        

    }

    public void MenuOptionsButton(AndroidDriver<AndroidElement> driver)
    {        
        List<AndroidElement> elements = driver.findElements(By.className("android.widget.ImageView"));
       for(AndroidElement element : elements) 
       {           
           if(element.getAttribute("contentDescription").equals("Navigation panel, button, double tap to open side panel")) 
           {
               element.click();               
               break;
           }
       }       
  }
    
    public void SearchProdcutByValue(AndroidElement className, String searchValue, AndroidDriver<AndroidElement> driver)
    {        
        List<AndroidElement> elements=driver.findElements(By.className(searchValue));
       for(AndroidElement element : elements) 
       {           
           if(element.getText().equals(searchValue)) 
           {
               element.click();               
               break;
           }
       }       
  }
    
    
    public void ScrollDown(AppiumDriver<AndroidElement> driver) {
        
        MobileElement element = driver.findElement
                (MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/drawer_item_title\")).scrollIntoView("
                 + "new UiSelector().text(\"Settings\"))"));
        element.click();
        
        /*Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * .8);
        int endY = (int) (size.height * .2);
        if (!element.isDisplayed()) 
            {
                driver.switchTo(startX, startY, startX, endY, 100);
            }
            driver.findElementById(customer).click();*/
        
    }
    
}
