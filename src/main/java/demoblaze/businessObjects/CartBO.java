package demoblaze.businessObjects;

import demoblaze.pages.CartPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Slf4j
@Component
public class CartBO {

    @Autowired
    private CartPO cartPO;

    public String getItemPrice(String itemName) {
        return cartPO.getItemPrice(itemName);
    }

    public String getTotalPrice() {
        return cartPO.getTotalPrice();
    }

    public CartBO deleteAllItems() {
        cartPO.deleteAllItems();
        log.info("Deleted all items from the Cart");
        return this;
    }

    public CartBO verifyTotalPrice(String expectedTotalPrice) {
        Assert.assertEquals(expectedTotalPrice, cartPO.getTotalPrice());
        return this;
    }

    public CartBO verifyCartIsEmpty() {
        cartPO.verifyCartIsEmpty();
        return this;
    }
}
