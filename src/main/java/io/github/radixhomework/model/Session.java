package io.github.radixhomework.model;

import io.github.radixhomework.enums.EnumSessionType;
import lombok.Data;
import lombok.ToString;

@Data
public class Session {

    @ToString.Exclude
    private String sessionid;
    private EnumSessionType sessionType;
    private String spaceName;
    private Integer admin;

    public void setSessionType(String value) {
        this.sessionType = EnumSessionType.fromValue(value);
    }
}
