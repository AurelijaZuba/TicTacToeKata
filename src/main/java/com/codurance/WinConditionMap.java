package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class WinConditionMap {
    List<WinCondition> winConditions;
    private BoardState boardState;

    public WinConditionMap(BoardState boardState) {
        this.boardState = boardState;
        initialiseWins();
    }

    private void initialiseWins() {
        winConditions = new ArrayList<>();
        winConditions.add(new WinCondition(new Position(0, 0), new Position(0, 1), new Position(0, 2)));
        winConditions.add(new WinCondition(new Position(1, 0), new Position(1, 1), new Position(1, 2)));
        winConditions.add(new WinCondition(new Position(2, 0), new Position(2, 1), new Position(2, 2)));
        winConditions.add(new WinCondition(new Position(0, 0), new Position(1, 0), new Position(2, 0)));
        winConditions.add(new WinCondition(new Position(0, 1), new Position(1, 1), new Position(2, 1)));
        winConditions.add(new WinCondition(new Position(0, 2), new Position(1, 2), new Position(2, 2)));
        winConditions.add(new WinCondition(new Position(0, 2), new Position(1, 1), new Position(2, 0)));
        winConditions.add(new WinCondition(new Position(2, 2), new Position(1, 1), new Position(0, 0)));
    }

    boolean winConditionHasBeenMet(boolean hasWon, WinCondition winCondition) {
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