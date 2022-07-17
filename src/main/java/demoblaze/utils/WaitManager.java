package demoblaze.utils;

import demoblaze.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static demoblaze.utils.properstiesReader.PropertiesConfig.CONFIG_PROPERTIES;

public class WaitManager {

    public static WebElement waitForElementToBeClickable(By by) {
        return getWait()
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitForElementToBeClickable(WebElement webElement) {
        return getWait()
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitForElementToBeDisplayed(By by) {
        return getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static Alert waitForAlert() {
        return getWait()
                .until(ExpectedConditions.alertIsPresent());
    }

    public static boolean waitForCondition(Function<WebDriver, Boolean> function) {
        return getWait()
                .until(function);
    }

    public static List<WebElement> waitForListOfElements(By by) {
        return getWait()
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static WebElement waitForElementToBePresent(By by) {
        return getWait()
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static Wait<WebDriver> getWait() {
        return new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(CONFIG_PROPERTIES.elementTimeout()));
    }
}
