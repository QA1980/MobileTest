package AppiumProject;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	//test
	 WebDriver driver;
	 By by;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities de = new DesiredCapabilities();
        de.setCapability("deviceName", "Pixel_3_API_30");
       // de.setCapability("BROWSER_NAME", "Chrome");
        de.setCapability("platformName", "Android");
        de.setCapability("app" , System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
       // de.setBrowserName("chrome");
       // de.setPlatform(org.openqa.selenium.Platform.MAC);
       // caps.setCapability("app" , System.getProperty("user.dir")+"/apps/selendroid-test-app-0.17.0.apk");
       // driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
       driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), de);
    }

    @Test
    public void test_Appium() throws MalformedURLException, InterruptedException {
       //Click continue 
    	driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
      //Click OK 
    	driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
    	 // 4. Click 'my_text_fieldCD'
    	by = By.id("io.selendroid.testapp:id/my_text_field");
        driver.findElement(by).click();
     // 5. Type 'qa tester' in 'my_text_fieldCD'
      
        by = By.id("io.selendroid.testapp:id/my_text_field");
        driver.findElement(by).sendKeys("qa tester");

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
