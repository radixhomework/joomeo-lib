package io.github.radixhomework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum EnumUserStatus {

    ENABLED(0),
    DISABLE_MAIL_NOT_CONFIRMED(1),
    DISABLED_INACTIVE_FILE_NOT_REMOVED(2),
    DISABLED_INACTIVE_FILE_REMOVED(3),
    DELETED(10);

    private final int value;

    public static EnumUserStatus fromValue(String value) {
        try {
            for (EnumUserStatus item : values()) {
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
