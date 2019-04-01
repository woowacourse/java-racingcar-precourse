package com.codemcd.racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goStraight() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
