import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    public static URL getWebdriverUrl(String apiToken) throws MalformedURLException {
        return new URL("https://appium-dev.headspin.io/v0/" + apiToken + "/wd/hub");
    }


    public static DesiredCapabilities buildCapabilities(String deviceName, String udid) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability("appPackage", "com.academy.android.uatmobile");
        caps.setCapability("appActivity", "com.asomobile.MainActivity");

        caps.setCapability("headspin:ignoreFailedDevices", false);
        caps.setCapability("headspin:selector", "device_id:\"" + udid + "\"");
        caps.setCapability("headspin:capture", true);
        return caps;
    }
}
