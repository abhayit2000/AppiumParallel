import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class DriverFactory {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setDriver(DesiredCapabilities caps) throws MalformedURLException {
        driver.set(new RemoteWebDriver(Helper.getWebdriverUrl("513e2708a80d4ccf9724d055ee5a6899"), caps));
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

}
