package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.radixhomework.enums.type.SessionType;
import lombok.Data;

@Data
public class Session {

    @JsonProperty("sessionid")
    private String sessionId;

    @JsonProperty("sessionType")
    private SessionType sessionType;

    @JsonProperty("spaceName")
    private String spaceName;

    @JsonProperty("admin")
    private Integer admin;

    @JsonProperty("user")
    private User user;

    public void setSessionType(String value) {
        this.sessionType = SessionType.fromValue(value);
    }
}
