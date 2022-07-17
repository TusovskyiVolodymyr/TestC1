package demoblaze.pages;

import demoblaze.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import static demoblaze.models.enums.CartTableColumns.PRICE;
import static demoblaze.utils.WaitManager.waitForCondition;
import static java.lang.String.format;

@Component
public class CartPO extends BasePO {

    private By totalPriceLocator = By.xpath("//*[@id='totalp']");
    private String rowLocator = "//*[@class = 'success']";
    private String rowByTextLocator = rowLocator + "//td[contains(text(), '%s')]//..";
    private String cellLocator = ".//td[%s]";
    private By deleteItemLocator = By.xpath(".//a[contains(text(), 'Delete')]");

    public String getTotalPrice() {
        return controller.getText(totalPriceLocator);
    }

    public WebElement getRowByText(String text) {
        return controller.getElement(rowByTextLocator, text);
    }

    public String getItemPrice(String itemName) {
        return controller.getText(getRowByText(itemName).findElement(By.xpath(format(cellLocator, PRICE.getIndex()))));
    }

    public CartPO deleteItemByName(String itemName) {
        controller.click(getRowByText(itemName).findElement(deleteItemLocator));
        return this;
    }

    public CartPO deleteAllItems() {
        controller.getListOfElements(By.xpath(rowLocator))
                .forEach(row ->
                        controller.click(row.findElement(deleteItemLocator)));
        return this;
    }

    public CartPO verifyCartIsEmpty() {
        Assert.assertTrue(waitForCondition(driver -> driver.findElements(By.xpath(rowLocator)).isEmpty()));
        return this;
    }
}
