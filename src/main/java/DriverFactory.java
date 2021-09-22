import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class DriverFactory {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setDriver(DesiredCapabilities caps) throws MalformedURLException {
        driver.set(new RemoteWebDriver(Helper.getWebdriverUrl("YOUR_HEADSPIN_ API_TOKEN_HERE"), caps));
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

}
