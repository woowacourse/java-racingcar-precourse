package racingcar;

import utils.RandomUtils;

public class Car {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;
    public static final int STOP_NUMBER = 3;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void race() {
        if (RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > STOP_NUMBER) {
            position++;
        }
    }
}
