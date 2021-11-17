package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Avatars {

    @JsonProperty("default")
    private String defaultValue;

}
