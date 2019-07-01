package com.codurance;

public class TicTacToeGame {


    private final BoardState boardState;
    private Player player;

    public TicTacToeGame() {
        boardState = new BoardState();
        player = Player.X;
    }

    public BoardState position(String player, String position) {
        this.player.valueOf(player);

        boardState.placeMarker(position, player);

        return boardState;
    }

    public Player nextPlayer() {
        if(player == Player.X)
            return Player.O;

        return Player.X;
    }
}
