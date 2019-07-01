package com.codurance;

import java.util.HashMap;

public class TicTacToeGame {
    public HashMap position(String player, String position) {
        HashMap boardState = new HashMap();

        boardState.put(position, player);

        return boardState;
    }
}
