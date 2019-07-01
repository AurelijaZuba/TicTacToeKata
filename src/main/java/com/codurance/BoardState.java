package com.codurance;

import java.util.HashMap;
import java.util.Objects;

public class BoardState {
    private final HashMap boardState;

    public BoardState() {
        boardState = new HashMap();
    }

    public void placeMarker(String position, String player) {
        boardState.put(position, player);
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

    public boolean emptyBoard() {
        return boardState.isEmpty();
    }
}