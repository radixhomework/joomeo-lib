package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Tag {

    @JsonProperty("tagid")
    private String tagId;

    @JsonProperty("category")
    private String category;

    @JsonProperty("label")
    private String label;

    @JsonProperty("createdDate")
    private OffsetDateTime createdDate;

    @JsonProperty("updatedDate")
    private OffsetDateTime updatedDate;
}
