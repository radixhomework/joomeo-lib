package io.github.radixhomework.enums.sorting;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SortingDirection {
    ASCENDANT("+"),
    DESCENDANT("-");

    private final String direction;

    public String sortField(SortingField field) {
        return this.direction + field.getField();
    }
}
