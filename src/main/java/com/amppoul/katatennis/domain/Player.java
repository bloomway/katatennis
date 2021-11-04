package com.amppoul.katatennis.domain;

import lombok.*;
@ToString(exclude = { "point" })
@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
public class Player {
    private final String name;
    private int point = 0;

    public void scorePoint() {
        this.point++;
    }
}
