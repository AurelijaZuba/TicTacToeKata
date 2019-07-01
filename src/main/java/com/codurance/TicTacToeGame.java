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
        BoardState winningBoard = new BoardState();
        winningBoard.placeMarker(new PlayerMove(new Position(0,0), Player.X));
        winningBoard.placeMarker(new PlayerMove(new Position(0,1), Player.X));
        winningBoard.placeMarker(new PlayerMove(new Position(0,2), Player.X));

        return winningBoard.equals(boardState);
    }
}
