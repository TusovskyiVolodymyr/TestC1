package demoblaze.pages;

import demoblaze.driver.DriverManager;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class ProductPO extends BasePO {
    private By productNameLocator = By.xpath("//*[@class='name']");
    private By addToCartLocator = By.xpath("//*[contains(@class, 'btn') and contains(., 'Add to cart')]");

    public ProductPO verifyProductName(String productName) {
        Assert.assertEquals(controller.getText(productNameLocator), productName);
        return this;
    }

    public ProductPO clickAddToCartButton() {
        controller.click(addToCartLocator);
        return this;
    }

    public ProductPO acceptAlert() {
        controller.acceptAlert();
        return this;
    }
}
