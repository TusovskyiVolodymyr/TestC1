package demoblaze.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static demoblaze.utils.properstiesReader.PropertiesConfig.CONFIG_PROPERTIES;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CONFIG_PROPERTIES.elementTimeout()));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
