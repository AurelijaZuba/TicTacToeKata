package com.codurance;

public class PlayerMove {
    private final Position position;
    private final Player player;

    public PlayerMove(Position position, Player player) {
        this.position = position;
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }
}
