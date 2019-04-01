package domain;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public boolean isMoveable() {
        return RandomUtils.getRandomNumber(1, 9) >= 4;
    }
}
