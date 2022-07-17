import demoblaze.businessObjects.CartBO;
import demoblaze.businessObjects.HomeBO;
import demoblaze.businessObjects.NavigationBO;
import demoblaze.models.enums.Categories;
import demoblaze.models.enums.NavbarTabs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CartTest extends BaseTest {

    private String[] items = {"HTC One M9", "Samsung galaxy s6"};

    @Value("${base.url}")
    private String check;

    @Autowired
    private HomeBO homeBO;
    @Autowired
    private NavigationBO navigationBO;
    @Autowired
    private CartBO cartBO;

    @Test
    public void cartTest() {
        homeBO.addItemsToCart(Categories.PHONES, items);
        navigationBO.navigateToTab(NavbarTabs.CART);

        String htcPrice = cartBO.getItemPrice(items[0]);
        String samsungPrice = cartBO.getItemPrice(items[1]);
        String totalPrice = new BigDecimal(htcPrice).add(new BigDecimal(samsungPrice)).toString();

        cartBO
                .verifyTotalPrice(totalPrice)
                .deleteAllItems()
                .verifyCartIsEmpty();
    }
}
