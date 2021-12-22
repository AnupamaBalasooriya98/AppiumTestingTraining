import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
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

public class MobitelSelfcareApp {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("BROWSER_NAME", "Android");
        cap.setCapability("VERSION", "5.1");
        cap.setCapability("deviceName", "HUAWEI LUA-U22");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator1");

        cap.setCapability("appPackage", "com.mobitel.selfcare");
        cap.setCapability("appActivity", "com.mobitel.selfcare.MainActivity");

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), cap);

        appLogin();
    }

    public void appLogin() throws InterruptedException {
        Thread.sleep(5000);
        // Select language as English
        WebElement language = driver.findElement(MobileBy.xpath("btnEn"));
        language.click();

        // Enter mobile number
//        WebElement number = driver.findElement(By.id("msisdn"));
//        number.sendKeys("710643226");

        // Enter OTP
//        driver.wait(10000);
    }

    @Test
    public void testLoginToTheApp() {

    }

    @AfterClass (enabled = false)
    public void afterClass() {
        driver.quit();
    }

}

/*{
        "deviceName": "HUAWEI LUA-U22",
        "udid": "G8M9XA1752902056",
        "platformName": "Android",
        "platformVersion": "5.1",
        "automationName": "UiAutomator1",
        "appPackage": "com.mobitel.selfcare",
        "appActivity": "com.mobitel.selfcare.MainActivity"
}*/

