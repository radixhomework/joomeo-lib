package io.github.radixhomework.util;

import io.github.radixhomework.enums.sorting.SortingDirection;
import io.github.radixhomework.enums.sorting.SortingField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.SortedMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortingUtils {

    public static <K extends SortingField> String toCsv(SortedMap<K, SortingDirection> input) {
        StringBuilder output = new StringBuilder();
        input.forEach((field, sorting) -> output.append(sorting.sortField(field)));
        return output.toString();
    }
}
