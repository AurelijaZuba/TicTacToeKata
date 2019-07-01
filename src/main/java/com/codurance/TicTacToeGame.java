package com.codurance;

public class TicTacToeGame {


    private final BoardState boardState;

    public TicTacToeGame() {
        boardState = new BoardState();
    }

    public BoardState position(String player, String position) {

        boardState.placeMarker(position, player);

        return boardState;
    }

    public Player nextPlayer() {
        return null;
    }
}
