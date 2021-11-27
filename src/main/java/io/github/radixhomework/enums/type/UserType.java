package io.github.radixhomework.enums.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum UserType {

    DEFAULT(0),
    ENTERPRISE(1);

    private final int value;

    public static UserType fromValue(String value) {
        try {
            for (UserType item : values()) {
                if (Integer.parseInt(value) == item.getValue()) {
                    return item;
                }
            }
        } catch (NumberFormatException nfe) {
            log.warn("Cannot parse {} as an integer", value);
        }
        return null;
    }
}
