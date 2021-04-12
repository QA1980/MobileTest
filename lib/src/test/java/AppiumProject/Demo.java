package AppiumProject;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	
	 MobileDriver<WebElement> driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName" , "UiAutomator1");
        caps.setCapability("platformName" , "Android");
        caps.setCapability("platformVersion" , "7.1.1");
        caps.setCapability("deviceName" , "Android Emulator");
        caps.setCapability("BROWSER_NAME", "Chrome");
        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
       // caps.setCapability("app" , System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
       // driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
       driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @Test
    public void test_Appium() throws MalformedURLException, InterruptedException {
       // String message = "Hello GitHub Actions";
       driver.navigate().to("https://staging.bperx.com/Voucher/Offer/AYH4CBK7LG2TT3N3XWJ9");
        System.out.println("The current URL is"+driver.getCurrentUrl());
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
