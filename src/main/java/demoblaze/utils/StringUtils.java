package demoblaze.utils;

import org.openqa.selenium.WebElement;

public class StringUtils {
    public static String getElementLocator(WebElement webElement) {
        return webElement.toString()
                .replaceAll(".*\\)\\] ->", "")
                .replaceAll("]]", "]");
    }
}
