package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Covers {

    @JsonProperty("tiny")
    private String tiny;
    @JsonProperty("small")
    private String small;
    @JsonProperty("medium")
    private String medium;
    @JsonProperty("large")
    private String large;
    @JsonProperty("default")
    private String defaultValue;

}
