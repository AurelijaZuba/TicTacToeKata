package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private final BoardState boardState;
    private Player currentPlayer;

    public TicTacToeGame() {
        boardState = new BoardState();
        currentPlayer = Player.X;
    }

    public BoardState position(PlayerMove playerMove) throws IllegalMoveException {
        currentPlayer = playerMove.getPlayer();

        if(!boardState.isLegalMove(playerMove)){
            throw new IllegalMoveException();
        }
        boardState.placeMarker(playerMove);

        return boardState;
    }

    public Player nextPlayer() {
        if (boardState.emptyBoard()) {
            return Player.X;
        }

        if (currentPlayer != Player.X) {
            return Player.X;
        }

        return Player.O;
    }

    public GameStatus status() {
        if(boardState.emptyBoard())
            return GameStatus.START_OF_GAME;
        if(gameHasBeenWon())
            return GameStatus.WON;
        if(!boardState.emptyBoard() && boardState.numberOfMoves() != 9)
            return GameStatus.IN_PLAY;

        return GameStatus.DRAW;
    }

    private boolean gameHasBeenWon() {
        PlayerMove playerMove1 = boardState.checkPlaceMarker(new Position(0,0));
        PlayerMove playerMove2 = boardState.checkPlaceMarker(new Position(0,1));
        PlayerMove playerMove3 = boardState.checkPlaceMarker(new Position(0,2));

        if(playerMove1 == null || playerMove2 == null || playerMove3 == null)
            return false;

        return playerMove1.getPlayer() == playerMove2.getPlayer()
                && playerMove2.getPlayer() == playerMove3.getPlayer();
    }
}
