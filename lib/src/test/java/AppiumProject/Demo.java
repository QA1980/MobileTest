package AppiumProject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	//test
	 WebDriver driver;
	 By by;
    @BeforeClass
    public void setUp() throws MalformedURLException {
    	System.out.println(System.getProperty("user.dir"));
        DesiredCapabilities de = new DesiredCapabilities();
        de.setCapability("deviceName", "Pixel_3_API_30");
       //de.setCapability("BROWSER_NAME", "Chrome");
        de.setCapability("platformName", "Android");
        de.setCapability(MobileCapabilityType.APP , System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
        //de.setBrowserName("chrome");
       //de.setPlatform(org.openqa.selenium.Platform.MAC);
        //caps.setCapability("app" , System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
       // driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
       driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), de);
    }

    @Test
    public void test_Appium() throws MalformedURLException, InterruptedException {
    	 // set timeout for driver actions (similar to step timeout)
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
//    	String message = "Hello GitHub Actions";
//       WebElement messageTxt = driver.findElement(By.id("my_text_field"));
//        messageTxt.sendKeys(message);
//        System.out.println(messageTxt.getText());
//       Assert.assertEquals(message,messageTxt.getText());
        by = By.id("io.selendroid.testapp:id/my_text_field");
    	    driver.findElement(by).click();
    	    
    	    by = By.id("io.selendroid.testapp:id/my_text_field");
    	   driver.findElement(by).sendKeys("qa tester");
    	
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
