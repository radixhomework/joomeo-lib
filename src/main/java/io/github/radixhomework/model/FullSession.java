package io.github.radixhomework.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FullSession extends Session {
    private User user;
}
