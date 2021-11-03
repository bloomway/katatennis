package com.amppoul.katatennis.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    private Player player1;
    private Player player2;
    private Game underTest;

    @BeforeEach
    public void setup() {
        player1 = Player.of("Nadal");
        player2 = Player.of("Federer");
        underTest = Game.of(player1, player2);
    }

    @Test
    public void gameStatusShouldDisplayLoveLove() {
        final var gameStatus = underTest.getStatus();
        assertEquals("love,love", gameStatus);
    }

}