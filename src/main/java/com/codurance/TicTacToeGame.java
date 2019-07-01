package com.codurance;

public class TicTacToeGame {
    private final BoardState boardState;
    private Player currentPlayer;

    public TicTacToeGame() {
        boardState = new BoardState();
        currentPlayer = Player.X;
    }

    public BoardState position(String position, String player) {
        currentPlayer.valueOf(player);

        boardState.placeMarker(position, player);

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
}
