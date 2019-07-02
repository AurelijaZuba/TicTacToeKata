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
        if(boardState.emptyBoard())
            return GameStatus.START_OF_GAME;
        if(gameHasBeenWon())
            return GameStatus.WON;
        if(!boardState.emptyBoard() && boardState.numberOfMoves() != 9)
            return GameStatus.IN_PLAY;

        return GameStatus.DRAW;
    }

    private boolean gameHasBeenWon() {
        boolean hasWon = false;

        WinConditionMap winConditionMap = new WinConditionMap(boardState);
        for (WinCondition winCondition : winConditionMap.winConditions) {
            hasWon = winConditionMap.winConditionHasBeenMet(hasWon, winCondition);
        }

        return hasWon;

    }

}
