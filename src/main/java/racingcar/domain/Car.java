package racingcar.domain;

import static racingcar.util.Constant.*;

import racingcar.util.Util;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private boolean isGoing() {
        return false;
    }

    public void move() {
        int random = Util.getRandomNumber(RANDOM_START, RANDOM_END);
    }

    @Override
    public String toString() {
        return "123";
    }
}
