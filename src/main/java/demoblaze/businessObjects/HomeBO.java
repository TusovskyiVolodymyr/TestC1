package demoblaze.businessObjects;

import demoblaze.models.enums.Categories;
import demoblaze.models.enums.NavbarTabs;
import demoblaze.pages.CategoriesPO;
import demoblaze.pages.ItemsPO;
import demoblaze.pages.NavBarPO;
import demoblaze.pages.ProductPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.String.format;

@Slf4j
@Component
public class HomeBO {

    @Autowired
    private ItemsPO itemsPO;
    @Autowired
    private CategoriesPO categoriesPO;
    @Autowired
    private NavBarPO navBarPO;
    @Autowired
    ProductPO productPO;

    public HomeBO selectCategory(Categories category) {
        categoriesPO.chooseCategory(category);
        return this;
    }

    public HomeBO selectItem(String itemName) {
        itemsPO.selectItem(itemName);
        return this;
    }

    public HomeBO addItemToCart(Categories category, String item) {
        selectCategory(category);
        selectItem(item);
        productPO.clickAddToCartButton();
        productPO.acceptAlert();
        log.info(format("Added item: %s of category: %s to Cart", item, category.getName()));
        return this;
    }

    public HomeBO addItemsToCart(Categories category, String... items) {
        Arrays.stream(items)
                .forEach(item -> {
                    addItemToCart(category, item);
                    navBarPO.selectNavBarTab(NavbarTabs.HOME);
                });
        return this;
    }
}
