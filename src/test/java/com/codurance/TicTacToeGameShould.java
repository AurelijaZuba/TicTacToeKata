package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeGameShould {

    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    void check_that_X_plays_first() {
        Player expectedPlayer = Player.X;

        Player playerToPlay = game.nextPlayer();

        assertThat(playerToPlay).isEqualTo(expectedPlayer);
    }

    @Test
    void check_that_O_plays_after_X() {
        Player expectedPlayer = Player.O;
        final PlayerMove playerMove = new PlayerMove("0,2", "X");

        BoardState boardState = game.position(playerMove);
        Player playerToPlay = game.nextPlayer();

        assertThat(playerToPlay).isEqualTo(expectedPlayer);
    }

    @Test
    void allow_first_player_X_to_mark_any_position() {
        final PlayerMove playerMove = new PlayerMove("0,2", "X");
        BoardState boardState = game.position(playerMove);

        BoardState expectedBoardState = new BoardState();
        expectedBoardState.placeMarker(playerMove);

        assertThat(boardState).isEqualTo(expectedBoardState);
    }

    @Test
    void not_allow_positions_to_be_played_twice() {
        assertThrows(IllegalMoveException.class, () -> {
            final PlayerMove firstMove = new PlayerMove("0,2", "X");
            final PlayerMove secondMove = new PlayerMove("0,2", "O");

            game.position(firstMove);
            BoardState boardState = game.position(secondMove);

            BoardState expectedBoardState = new BoardState();
            expectedBoardState.placeMarker(firstMove);
            expectedBoardState.placeMarker(secondMove);
        });
    }
}
