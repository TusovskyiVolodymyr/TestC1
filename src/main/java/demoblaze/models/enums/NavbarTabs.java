package demoblaze.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NavbarTabs {
    HOME("Home"),
    CONTACT("Contact"),
    ABOUT_US("About us"),
    CART("Cart"),
    LOG_IN("Log in"),
    LOG_OUT("Log out"),
    SIGN_UP("Sign up");

    private String tabName;
}
