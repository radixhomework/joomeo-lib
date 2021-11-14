package io.github.radixhomework.model;

import lombok.Data;

@Data
public class Avatars {
    private String defaultValue;

    public String getDefault() {
        return this.defaultValue;
    }

    public void setDefault(String value) {
        this.defaultValue = value;
    }
}
