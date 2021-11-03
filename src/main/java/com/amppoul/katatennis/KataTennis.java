package com.amppoul.katatennis;

import com.amppoul.katatennis.domain.Game;
import com.amppoul.katatennis.domain.Player;

public class KataTennis {

    public static void main(String[] args) {
        final Player nadal = Player.of("Nadal");
        final Player federer = Player.of("Federer");

        final Game game = Game.of(nadal, federer);
        nadal.scores();
        nadal.scores();

        game.getStatus();
    }
}
