package com.amppoul.katatennis.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final Player underTest = Player.of("Nadal");

    @Test
    public void scoreShouldBeEqualsToZero() {
        assertEquals(0, underTest.getPoint());
    }

    @Test
    public void scoreShouldBeEqualsToOne() {
        underTest.scorePoint();
        assertEquals(1, underTest.getPoint());
    }

    @Test
    public void scoreShouldBeEqualsToThree() {
        underTest.scorePoint();
        underTest.scorePoint();
        underTest.scorePoint();
        assertEquals(3, underTest.getPoint());
    }

    @Test
    public void scoreShouldBeEqualsToSix() {
        underTest.scorePoint();
        underTest.scorePoint();
        underTest.scorePoint();
        underTest.scorePoint();
        underTest.scorePoint();
        underTest.scorePoint();
        assertEquals(6, underTest.getPoint());
    }
}