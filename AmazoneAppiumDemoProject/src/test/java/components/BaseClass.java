package components;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends ExtnReports {

    protected static AndroidDriver<AndroidElement> driver; 
    static ExtentTest test;
       
    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ShashiCD");
            caps.setCapability(MobileCapabilityType.UDID, "64f9d45d7ce5");
            caps.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.0");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);  
            caps.setCapability("unicodeKeyboard", "true");                                     
            caps.setCapability("resetKeyboard", "true");
           
            caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");            
            caps.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
         
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            
        }catch(Exception exp) {
            test.info("Cause is : "+exp.getCause());            
            System.out.println("Message is :" +exp.getMessage());
            exp.printStackTrace();
        }   
    }    


    @AfterTest
    public void teardown() {
        driver.quit();
    }
    
    


}