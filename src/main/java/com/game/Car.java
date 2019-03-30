package com.game;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        final int delta = (int) (Math.random() * 10);
        if (3 < delta) {
            ++position;
            return;
        }
        --position;
        if (position < 0) {
            position = 0;
        }
    }

    public int getPosition() {
        return position;
    }
}
