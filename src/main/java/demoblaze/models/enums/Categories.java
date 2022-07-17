package demoblaze.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Categories {
    PHONES("Phones"),

    LAPTOPS("Laptops"),

    MONITORS("Monitors");

    private String name;
}
