package io.github.radixhomework.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumJoomeoHeader {
    X_SESSIONID("X-SESSIONID"),
    X_API_KEY("X-API-KEY"),
    X_COUNTRY("X-COUNTRY"),
    X_LANG("X-LANG"),
    X_RESPONSE_ENVELOPE("X-RESPONSE-ENVELOPE"),
    X_RESPONSE_TYPE("X-RESPONSE-TYPE"),
    X_LIST_LIMIT("X-LIST-LIMIT"),
    X_LIST_OFFSET("X-LIST-OFFSET"),
    X_LIST_SORT("X-LIST-SORT"),
    X_FIELDS("X-FIELDS"),
    X_FILTER("X-FILTER"),
    X_HISTORY("X-HISTORY"),
    X_STATS("X-STATS"),
    X_CONTEXT("X-CONTEXT"),
    X_PAYLOAD_TYPE("X-PAYLOAD-TYPE"),
    X_ADDITIONAL_FIELDS("X-ADDITIONAL-FIELDS"),
    X_DATETIME_FORMAT("X-DATETIME-FORMAT"),
    X_DELETED("X-DELETED");

    private final String header;

    public String value() {
        return header;
    }
}
