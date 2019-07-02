package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private final BoardState boardState;
    private Player currentPlayer;
    private List<WinCondition> winConditions;

    public TicTacToeGame() {
        boardState = new BoardState();
        currentPlayer = Player.X;
        initialiseWins();
    }

    private void initialiseWins() {
        winConditions = new ArrayList<>();
        winConditions.add(new WinCondition(new Position(0,0), new Position(0,1), new Position(0,2)));
        winConditions.add(new WinCondition(new Position(1,0), new Position(1,1), new Position(1,2)));
        winConditions.add(new WinCondition(new Position(2,0), new Position(2,1), new Position(2,2)));
        winConditions.add(new WinCondition(new Position(0,0), new Position(1,0), new Position(2,0)));
        winConditions.add(new WinCondition(new Position(0,1), new Position(1,1), new Position(2,1)));
        winConditions.add(new WinCondition(new Position(0,2), new Position(1,2), new Position(2,2)));
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

        for (WinCondition winCondition : winConditions) {
            hasWon = winConditionHasBeenMet(hasWon, winCondition);
        }

        return hasWon;

    }

    private boolean winConditionHasBeenMet(boolean hasWon, WinCondition winCondition) {
        Player playerMove1 = boardState.checkPlaceMarker(winCondition.getPosition1());
        Player playerMove2 = boardState.checkPlaceMarker(winCondition.getPosition2());
        Player playerMove3 = boardState.checkPlaceMarker(winCondition.getPosition3());

        if(areMovesNull(playerMove1, playerMove2, playerMove3)) {
            return hasWon;
        }

        return playerMove1 == playerMove2 && playerMove2 == playerMove3;
    }

    private boolean areMovesNull(Player playerMove1, Player playerMove2, Player playerMove3) {
        return playerMove1 == null || playerMove2 == null || playerMove3 == null;
    }
}
