package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OnlineStore {

    @JsonProperty("subscriptionStep")
    private boolean subscriptionStep;

    @JsonProperty("profileStep")
    private boolean profileStep;

    @JsonProperty("finalStep")
    private boolean finalStep;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("activated")
    private boolean activated;

    @JsonProperty("photoLab")
    private boolean photoLab;

    @JsonProperty("binary")
    private boolean binary;
}
