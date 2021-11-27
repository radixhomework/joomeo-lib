package io.github.radixhomework.enums.sorting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TagSortingField implements SortingField {
    CATEGORY("category"),
    LABEL("label"),
    CREATED_DATE("createdDate");

    @Getter
    private final String field;
}
