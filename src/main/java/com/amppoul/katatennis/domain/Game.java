package com.amppoul.katatennis.domain;

import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
public class Game {
    private final Player player1;
    private final Player player2;

    public String getScore() {

        if (isDeuce()) {
            return "deuce";
        }

        if (hasAdvantage()) {
            return "advantage, " + getPlayerWithHigherPoint();
        }

        if(hasWinner()) {
            return "winner, " + getPlayerWithHigherPoint();
        }
        return transcodification(player1.getPoint()) + "-" + transcodification(player2.getPoint());
    }

    private String getPlayerWithHigherPoint() {
        return player1.getPoint() > player2.getPoint() ?
                player1.getName() : player2.getName();
    }

    private boolean hasAdvantage() {
        if(player2.getPoint() >= 4 &&
                player2.getPoint() - player1.getPoint() == 1)
            return true;
        return player1.getPoint() >= 4 &&
                player1.getPoint() - player2.getPoint() == 1;
    }

    private boolean hasWinner() {
        if(player2.getPoint() >= 4 &&
                player2.getPoint() - player1.getPoint() >= 2)
            return true;

        return player1.getPoint() >= 4 &&
                player1.getPoint() - player2.getPoint() >= 2;
    }

    private boolean isDeuce() {
        return player1.getPoint() == player2.getPoint() &&
                player2.getPoint() >= 3;
    }

    public String transcodification(int point) {
        switch (point) {
            case 0:
                return "love";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                throw new IllegalArgumentException("Illegal point " + point);
        }
    }
}
