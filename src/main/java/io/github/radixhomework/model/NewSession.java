package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Bean for creating a new session.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewSession {

    private String spaceName;
    private String login;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;
    private String contactid;
    private String token;
}
