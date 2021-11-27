package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TagList {

    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("first")
    private PageNavigation first;
    @JsonProperty("last")
    private PageNavigation last;
    @JsonProperty("prev")
    private PageNavigation prev;
    @JsonProperty("next")
    private PageNavigation next;
    @JsonProperty("list")
    private List<Tag> tags;
}
