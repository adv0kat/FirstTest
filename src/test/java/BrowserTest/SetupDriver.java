package BrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class SetupDriver {
    public static List<String> driverNames = Arrays.asList(
            "chrome",
            "firefox",
            "edge");

    public WebDriver getDriver(String driverName) {
        String path = System.getProperty("user.dir");

        String driverPath;

        switch (driverName) {
            case "chrome":
                driverPath = path + "/src/main/resources/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions options = new ChromeOptions();


                DesiredCapabilities caps = new DesiredCapabilities(options);
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.BROWSER, Level.ALL);
                caps.setCapability(ChromeOptions.CAPABILITY, logPrefs);
                options.setCapability(ChromeOptions.CAPABILITY, caps);
                WebDriver driver = new ChromeDriver(options);
                return driver;
            case "firefox":
                driverPath = path + "/src/main/resources/drivers/geckodriver.exe";
                System.setProperty("Webdriver.firefox.driver", driverPath);
                return new FirefoxDriver();
            case "edge":
                driverPath = path + "/src/main/resources/drivers/msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", driverPath);
                return new EdgeDriver();
            default:
                return null;
        }
    }

}
