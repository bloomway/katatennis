package com.amppoul.katatennis.domain;

import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
public class Game {
    private final Player player1;
    private final Player player2;

    public String getStatus() {
        return "love,love";
    }
}
