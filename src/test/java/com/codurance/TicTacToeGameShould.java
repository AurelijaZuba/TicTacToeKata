package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeGameShould {

    @Test
    void allow_first_player_X_to_mark_any_position() {
        TicTacToeGame game = new TicTacToeGame();
        BoardState gameState = game.position("X", "0,2");

        BoardState expected = new BoardState();
        expected.placeMarker("0,2", "X");

        assertThat(gameState).isEqualTo(expected);
    }
}
