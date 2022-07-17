package demoblaze.pages;

import demoblaze.models.enums.NavbarTabs;
import org.springframework.stereotype.Component;

@Component
public class NavBarPO extends BasePO {

    private String navBarTabLocator = "//*[contains(@class, 'nav-item') and contains(., '%s')]";

    public NavBarPO selectNavBarTab(NavbarTabs tab) {
        controller.click(navBarTabLocator, tab.getTabName());
        return this;
    }
}
