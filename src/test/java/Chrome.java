import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Chrome {
    AppiumDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("BROWSER_NAME", "Android");
        cap.setCapability("VERSION", "5.1");
        cap.setCapability("deviceName", "HUAWEI LUA-U22");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator1");

        cap.setCapability("appPackage", "com.android.chrome");
        cap.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }

    public void loginApp() {

    }

    @Test
    public void testWebView() throws InterruptedException {
        Thread.sleep(5000);
        driver.context(getWebContext(driver));
        driver.get("courseweb.sliit.lk");

        assert driver.getTitle().equals("CourseWeb | Sri Lanka Institute of Information Technology");
    }

    @Nullable
    private String getWebContext (AppiumDriver driver) {
        ArrayList<String> contexts = new ArrayList<String>(driver.getContextHandles());

        for (String context : contexts) {
            if (!context.equals("NATIVE_APP")) {
                return context;
            }
        }

        return null;
    }
}
