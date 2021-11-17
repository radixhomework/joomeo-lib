package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Error {

    @JsonProperty("internalCode")
    private Integer internalCode;
    @JsonProperty("endUserMessage")
    private String endUserMessage;
    @JsonProperty("internalMessage")
    private String internalMessage;

}
