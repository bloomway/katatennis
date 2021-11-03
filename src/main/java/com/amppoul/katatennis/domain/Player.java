package com.amppoul.katatennis.domain;

import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
public class Player {
    private final String name;
    private int score = 0;

    public void scores() {
    }
}
