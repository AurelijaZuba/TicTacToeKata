package com.codurance;

public class PlayerMove {
    private final String position;
    private final String player;

    public PlayerMove(String position, String player) {
        this.position = position;
        this.player = player;
    }

    public String getPosition() {
        return position;
    }

    public String getPlayer() {
        return player;
    }
}
