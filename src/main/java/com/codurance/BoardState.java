package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardState {
    private final List boardState;

    public BoardState() {
        boardState = new ArrayList();
    }

    public void placeMarker(PlayerMove playerMove) {
        boardState.add(playerMove);
    }

    public boolean emptyBoard() {
        return boardState.isEmpty();
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