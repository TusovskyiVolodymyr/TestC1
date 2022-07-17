package demoblaze.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CartTableColumns {
    PIC(1),
    TITLE(2),
    PRICE(3),
    DELETE(4);

    private int index;
}
