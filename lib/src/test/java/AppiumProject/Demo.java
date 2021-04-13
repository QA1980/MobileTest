package AppiumProject;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	//test
	 MobileDriver driver;
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
        String message = "Hello GitHub Actions";
        WebElement messageTxt = driver.findElement(By.id("my_text_field"));
        messageTxt.sendKeys(message);
        System.out.println(messageTxt.getText());
        Assert.assertEquals(message,messageTxt.getText());
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
