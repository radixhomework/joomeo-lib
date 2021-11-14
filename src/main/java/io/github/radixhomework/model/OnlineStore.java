package io.github.radixhomework.model;

import lombok.Data;

@Data
public class OnlineStore {
    private boolean subscriptionStep;
    private boolean profileStep;
    private boolean finalStep;
    private boolean enabled;
    private boolean activated;
}
