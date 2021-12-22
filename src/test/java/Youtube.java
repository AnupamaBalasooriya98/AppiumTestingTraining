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

public class Youtube {

    /*
    *
    * For web view testing
    *
     */

    AppiumDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("BROWSER_NAME", "Android");
        cap.setCapability("VERSION", "5.1");
        cap.setCapability("deviceName", "HUAWEI LUA-U22");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator1");

        cap.setCapability("appPackage", "com.google.android.youtube");
        cap.setCapability("appActivity", "com.google.android.libraries.youtube.player.features.gl.vr.VrWelcomeActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }

    public void loginApp() {

    }

    @Test
    public void testWebView() throws InterruptedException {
        Thread.sleep(5000);
        driver.context(getWebContext(driver));
        driver.get("https://youtu.be/Rt_UqUm38BI");

        assert driver.getTitle().equals("Marvel Studios' Doctor Strange in the Multiverse of Madness | Official Teaser");
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
