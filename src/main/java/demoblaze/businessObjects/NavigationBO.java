package demoblaze.businessObjects;

import demoblaze.models.enums.NavbarTabs;
import demoblaze.pages.NavBarPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigationBO {

    @Autowired
    private NavBarPO navBarPO;

    public NavigationBO navigateToTab(NavbarTabs tab) {
        navBarPO.selectNavBarTab(tab);
        return this;
    }
}
