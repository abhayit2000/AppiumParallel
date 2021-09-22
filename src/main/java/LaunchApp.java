import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class LaunchApp {
    private RemoteWebDriver driver;

    @DataProvider(name = "devices", parallel = true)
    public static Object[][] getDevices() {
        return new Object[][]{
                {"Galaxy Note 10", "R58M90C3T2F"},
                {"Moto G", "ZY22BXLJ98"},
                {"Galaxy S10", "RF8NA1NL4WK"}
        };
    }

    @Test(dataProvider = "devices", invocationCount = 2)
    public void LaunchApp(String deviceName, String udid) throws MalformedURLException {
        System.out.println("Running on [" + deviceName + "] with udid: [" + udid + "]");
        DriverFactory.setDriver(Helper.buildCapabilities(deviceName, udid));
        driver = DriverFactory.getDriver();
        System.out.println("Created driver with session ID: " + driver.getSessionId().toString());

        System.out.println("Quitting driver ");
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Failed to quit driver");
        }
    }

}
