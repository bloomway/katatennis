package com.amppoul.katatennis.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final Player player1 = Player.of("Nadal");
    private final Player player2 = Player.of("Federer");
    private final Game underTest = Game.of(player1, player2);

    @Test
    public void gameStatusShouldDisplayLoveLove() {
        final var gameStatus = underTest.getScore();
        assertEquals("love-love", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayFifteenLove() {
        player1.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("15-love", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayFifteenFifteen() {
        player1.scorePoint();
        player2.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("15-15", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayThirtyLove() {
        player1.scorePoint();
        player1.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("30-love", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayFortyLove() {
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("40-love", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayFifteenThirty() {
        player1.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("15-30", gameStatus);
    }

    @Test
    public void gameStatusShouldDisplayFifteenForty() {
        player1.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        final var gameStatus = underTest.getScore();
        assertEquals("15-40", gameStatus);
    }

    @Test
    public void getPointShouldDisplayLove() {
        final var point = underTest.transcodification(0);
        assertEquals("love", point);
    }

    @Test
    public void getPointShouldDisplayFifteen() {
        final var point = underTest.transcodification(1);
        assertEquals("15", point);
    }

    @Test
    public void getPointShouldDisplayThirty() {
        final var point = underTest.transcodification(2);
        assertEquals("30", point);
    }

    @Test
    public void getPointShouldDisplayForty() {
        final var point = underTest.transcodification(3);
        assertEquals("40", point);
    }

    @Test
    public void getPointShouldThrowIllegalExceptionWhenScoreIsNotValid() {
        final var exception = assertThrows(IllegalArgumentException.class,
                () -> underTest.transcodification(10));

        final var expectedMessage = "Illegal point";
        final var actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void itShouldDisplayDeuce() {
        player1.scorePoint();
        player1.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("deuce", score);
    }

    @Test
    public void itShouldDisplayConcatenateAdvantageAndTheNameOfThePlayer() {
        player1.scorePoint();
        player1.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("advantage, " + player1.getName(), score);
    }

    @Test
    public void itShouldDisplayWinnerOfTheGameWhenScoreIsAtLeast3BytheTwoPlayers() {
        player1.scorePoint();
        player1.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player2.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("winner, " + player1.getName(), score);
    }

    @Test
    public void itShouldDisplayWinnerOfTheGameWhenPlayer2HasZeroPoint() {
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("winner, " + player1.getName(), score);
    }

    @Test
    public void itShouldDisplayWinnerOfTheGameWhenPlayer2OnePoint() {
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        player2.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("winner, " + player1.getName(), score);
    }

    @Test
    public void itShouldDisplayWinnerOfTheGameWhenPlayer2TwoPoints() {
        player2.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        player1.scorePoint();
        player2.scorePoint();
        player1.scorePoint();
        final var score = underTest.getScore();
        assertEquals("winner, " + player1.getName(), score);
    }

}