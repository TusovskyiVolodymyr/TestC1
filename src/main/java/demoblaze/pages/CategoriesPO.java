package demoblaze.pages;

import demoblaze.driver.DriverManager;
import demoblaze.models.enums.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriesPO extends BasePO{
    private By categoriesList = By.xpath("//*[@id='itemc']");

    public List<WebElement> getCategoriesList() {
        return controller.getListOfElements(categoriesList);
    }

    public void chooseCategory(Categories category) {
        getCategoriesList().stream()
                .filter(webElement -> webElement.getText().contains(category.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no category with name: " + category.getName()))
                .click();
    }
}
