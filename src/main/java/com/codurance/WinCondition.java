package com.codurance;

public class WinCondition {
    private final Position position1;
    private final Position position2;
    private final Position position3;

    public WinCondition(Position playerMove1, Position playerMove2, Position playerMove3) {
        this.position1 = playerMove1;
        this.position2 = playerMove2;
        this.position3 = playerMove3;
    }

    public Position getPosition1() {
        return position1;
    }

    public Position getPosition2() {
        return position2;
    }

    public Position getPosition3() {
        return position3;
    }
}
