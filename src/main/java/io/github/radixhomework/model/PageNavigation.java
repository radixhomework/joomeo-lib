package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageNavigation {

    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
}
