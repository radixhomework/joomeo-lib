package io.github.radixhomework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSessionType {

    AUTO(-1, "auto", true),
    MANAGER(0, "manager", true),
    GUEST(1, "guest", true),
    CART(3, "cart", false),
    NETWORK(-2, "network", true),
    PREVIEW(-3, "preview", true),
    TOKEN(-4, "token", true);

    private final int id;
    private final String value;
    private final boolean forQuery;

    public static EnumSessionType fromValue(String value) {
        for (EnumSessionType item : EnumSessionType.values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
            try {
                int intValue = Integer.parseInt(value);
                if (intValue == item.getId()) {
                    return item;
                }
            } catch (NumberFormatException nfe) {
                // Nothing to do
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (this.forQuery) {
            return this.getValue();
        } else {
            return String.valueOf(this.getId());
        }
    }
}
