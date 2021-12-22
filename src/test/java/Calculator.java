import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "5.1");
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName", "UiAutomator1");


        capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testCal() throws Exception {
        System.out.println("test");
        //locate the Text on the calculator by using By.name()
        WebElement two= driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"2\"]"));
        two.click();
        WebElement plus=driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"plus\"]"));
        plus.click();
        WebElement four=driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"4\"]"));
        four.click();
        WebElement equalTo=driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"equals\"]"));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        String editBox = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ViewSwitcher/android.widget.EditText";
        WebElement results=driver.findElement(MobileBy.xpath(editBox));
        //Check the calculated value on the edit box
        assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

    }

    @AfterClass (enabled = false)
    public void teardown(){
        //close the app
        driver.quit();
    }
}

/* {
  "deviceName": "HUAWEI LUA-U22",
  "udid": "G8M9XA1752902056",
  "platformName": "Android",
  "platformVersion": "5.1",
  "automationName": "UiAutomator1",
  "appPackage": "com.android.calculator2",
  "appActivity": "com.android.calculator2.Calculator"
} */

