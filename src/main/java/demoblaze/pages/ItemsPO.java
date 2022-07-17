package demoblaze.pages;

import demoblaze.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Component
public class ItemsPO extends BasePO {

    private By itemsList = By.xpath("//*[contains(@class, 'card h-100')]");
    private String itemLocator = "//*[@class='hrefch' and contains(., '%s')]";

    public List<WebElement> getItems() {
        return controller.getListOfElements(itemsList);
    }

    public void selectItem(String itemName) {
        controller.click(itemLocator, itemName);
    }

}
