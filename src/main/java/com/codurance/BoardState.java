package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardState {
    private final List<PlayerMove> boardState ;

    public BoardState() {
        boardState = new ArrayList();
    }

    public void placeMarker(PlayerMove playerMove) {
        boardState.add(playerMove);
    }

    public boolean emptyBoard() {
        return boardState.isEmpty();
    }

    boolean isLegalMove(PlayerMove playerMove) {
        if(positionHasBeenPlayed(playerMove.getPosition()))
            return false;
        return true;
    }

    private boolean positionHasBeenPlayed(Position position) {
       boolean hasBeenPlayed = false;

        for (Position move: getPlayedPositions()) {
            hasBeenPlayed = move.equals(position);
        }
        return hasBeenPlayed;
    }

    private List<Position> getPlayedPositions() {
        List<Position> positionsPlayed = new ArrayList();

        for(PlayerMove move : boardState) {
            Position position = move.getPosition();
            positionsPlayed.add(position);
        }
        return positionsPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardState that = (BoardState) o;
        return Objects.equals(boardState, that.boardState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardState);
    }

    public int numberOfMoves() {
        return boardState.size();
    }
}