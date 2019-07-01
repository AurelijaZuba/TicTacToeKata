package com.codurance;

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
        return GameStatus.DRAW;
    }
}
