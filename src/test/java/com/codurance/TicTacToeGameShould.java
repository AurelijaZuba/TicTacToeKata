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
    void check_that_O_plays_after_X() throws IllegalMoveException {
        Player expectedPlayer = Player.O;
        final PlayerMove playerMove = new PlayerMove(new Position(0,2), Player.X);

        BoardState boardState = game.position(playerMove );
        Player playerToPlay = game.nextPlayer();

        assertThat(playerToPlay).isEqualTo(expectedPlayer);
    }

    @Test
    void allow_first_player_X_to_mark_any_position() throws IllegalMoveException {
        final PlayerMove playerMove = new PlayerMove(new Position(0,2), Player.X);
        BoardState boardState = game.position(playerMove);

        BoardState expectedBoardState = new BoardState();
        expectedBoardState.placeMarker(playerMove);

        assertThat(boardState).isEqualTo(expectedBoardState);
    }

    @Test
    void not_allow_positions_to_be_played_twice() {
        assertThrows(IllegalMoveException.class, () -> {
            final PlayerMove firstMove = new PlayerMove(new Position(0,2), Player.X);
            final PlayerMove secondMove = new PlayerMove(new Position(0,2), Player.O);

            game.position(firstMove);
            BoardState boardState = game.position(secondMove);

            BoardState expectedBoardState = new BoardState();
            expectedBoardState.placeMarker(firstMove);
            expectedBoardState.placeMarker(secondMove);
        });
    }

    @Test
    void finish_the_game_if_its_a_draw() throws IllegalMoveException {
        final PlayerMove firstMove = new PlayerMove(new Position(0,2), Player.X);
        final PlayerMove secondMove = new PlayerMove(new Position(2,0), Player.O);
        final PlayerMove thirdMove = new PlayerMove(new Position(0,0), Player.X);
        final PlayerMove fourthMove = new PlayerMove(new Position(0,1), Player.O);
        final PlayerMove fifthMove = new PlayerMove(new Position(1,1), Player.X);
        final PlayerMove sixthMove = new PlayerMove(new Position(2,2), Player.O);
        final PlayerMove seventhMove = new PlayerMove(new Position(2,1), Player.X);
        final PlayerMove eithMove = new PlayerMove(new Position(1,2), Player.O);
        final PlayerMove ninthMove = new PlayerMove(new Position(1,0), Player.X);
        GameStatus expectedGameStatus = GameStatus.DRAW;


        game.position(firstMove);
        game.position(secondMove);
        game.position(thirdMove);
        game.position(fourthMove);
        game.position(fifthMove);
        game.position(sixthMove);
        game.position(seventhMove);
        game.position(eithMove);
        BoardState boardState =  game.position(ninthMove);
        GameStatus actualGameStatus = game.status();

        assertThat(actualGameStatus).isEqualTo(expectedGameStatus);
    }

    @Test
    void show_status_as_START_OF_GAME_when_a_new_game_is_started() {
        GameStatus expectedGameStatus = GameStatus.START_OF_GAME;

        GameStatus actualGameStatus = game.status();

        assertThat(actualGameStatus).isEqualTo(expectedGameStatus);
    }


    @Test
    void show_status_as_IN_PLAY_while_in_the_middle_of_the_game() throws IllegalMoveException {
        final PlayerMove firstMove = new PlayerMove(new Position(0,2), Player.X);
        GameStatus expectedGameStatus = GameStatus.IN_PLAY;

        BoardState boardState = game.position(firstMove);
        GameStatus actualGameStatus = game.status();

        assertThat(actualGameStatus).isEqualTo(expectedGameStatus);
    }

    @Test
    void show_status_WON_when_three_in_a_row_vertical_left() throws IllegalMoveException {
        GameStatus expectedGameStatus = GameStatus.WON;

        final PlayerMove firstMove = new PlayerMove(new Position(0,0), Player.X);
        final PlayerMove secondMove = new PlayerMove(new Position(1,0), Player.O);
        final PlayerMove thirdMove = new PlayerMove(new Position(0,1), Player.X);
        final PlayerMove fourthMove = new PlayerMove(new Position(1,1), Player.O);
        final PlayerMove fifthMove = new PlayerMove(new Position(0,2), Player.X);

        game.position(firstMove);
        game.position(secondMove);
        game.position(thirdMove);
        game.position(fourthMove);
        game.position(fifthMove);
        GameStatus actualGameStatus = game.status();

        assertThat(actualGameStatus).isEqualTo(expectedGameStatus);
    }

    @Test
    void show_status_WON_when_three_in_a_row_vertical_middle() throws IllegalMoveException {
        GameStatus expectedGameStatus = GameStatus.WON;

        final PlayerMove firstMove = new PlayerMove(new Position(1,0), Player.X);
        final PlayerMove secondMove = new PlayerMove(new Position(0,0), Player.O);
        final PlayerMove thirdMove = new PlayerMove(new Position(1,1), Player.X);
        final PlayerMove fourthMove = new PlayerMove(new Position(0,1), Player.O);
        final PlayerMove fifthMove = new PlayerMove(new Position(1,2), Player.X);

        game.position(firstMove);
        game.position(secondMove);
        game.position(thirdMove);
        game.position(fourthMove);
        game.position(fifthMove);
        GameStatus actualGameStatus = game.status();

        assertThat(actualGameStatus).isEqualTo(expectedGameStatus);
    }
}
