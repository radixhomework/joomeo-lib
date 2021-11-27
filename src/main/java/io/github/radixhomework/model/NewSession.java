package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Bean for creating a new session.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewSession {

    @JsonProperty("spaceName")
    private String spaceName;

    @JsonProperty("login")
    private String login;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty("password")
    private String password;

    @JsonProperty("contactid")
    private String contactId;

    @JsonProperty("token")
    private String token;
}
