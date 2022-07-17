package demoblaze.driver;

import demoblaze.utils.StringUtils;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

import static demoblaze.utils.WaitManager.*;
import static java.lang.String.format;


@Component
@Slf4j
public class DriverController {

    public void click(By by) {
        WebElement webElement = waitForElementToBeClickable(by);
        try {
            click(webElement);
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            webElement = waitForElementToBeClickable(by);
            click(webElement);
        }
    }

    public void click(WebElement webElement) {
        waitForElementToBeClickable(webElement).click();
        log.debug("Click on element: " + StringUtils.getElementLocator(webElement));
    }

    public void click(String locator, String... params) {
        click(resolveParams(locator, params));
    }

    public String getText(By by) {
        String text = "";
        WebElement webElement;
        try {
            webElement = waitForElementToBeDisplayed(by);
            text = getText(webElement);
        } catch (StaleElementReferenceException e) {
            webElement = waitForElementToBeDisplayed(by);
            text = getText(webElement);
        }
        return text;
    }

    public String getText(WebElement webElement) {
        String text = webElement.getText();
        log.debug(format("Getting element: %s text: %s", StringUtils.getElementLocator(webElement), text));
        return text;
    }

    public void acceptAlert() {
        waitForAlert().accept();
        log.debug("Alert was accepted");
    }

    public List<WebElement> getListOfElements(By by) {
        return waitForListOfElements(by);
    }

    public WebElement getElement(String locator, String... params) {
        return waitForElementToBePresent(resolveParams(locator, params));
    }

    private By resolveParams(String locator, String... params) {
        return By.xpath(format(locator, params));
    }
}
