package io.github.radixhomework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumDateTimeFormat {

    TIMESTAMP("timestamp"),
    UTC("utc");

    private final String value;

    public static EnumDateTimeFormat fromValue(String value) {
        for (EnumDateTimeFormat item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
