package io.github.radixhomework.enums.format;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DateTimeFormat {

    TIMESTAMP("timestamp"),
    UTC("utc");

    private final String value;

    public static DateTimeFormat fromValue(String value) {
        for (DateTimeFormat item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
