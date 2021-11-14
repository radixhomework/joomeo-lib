package io.github.radixhomework.model;

import lombok.Data;

@Data
public class Covers {

    private String tiny;
    private String small;
    private String medium;
    private String large;
    private String defaultValue;

    public String getDefault() {
        return this.defaultValue;
    }

    public void setDefault(String value) {
        this.defaultValue = value;
    }
}
