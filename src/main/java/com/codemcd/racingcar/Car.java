package com.codemcd.racingcar;

public class Car {

    private static final int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goStraight(int moveNumber) {
        if (moveNumber >= MIN_MOVE_NUMBER)
            this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
