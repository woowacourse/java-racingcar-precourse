package racingcar.domain;

import utils.RandomUtils;

public class Car {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MARCH_ORDER_STANDARD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private boolean CheckMarchOrder(int randomNumber) {
        if (randomNumber >= MARCH_ORDER_STANDARD) {
            return true;
        }
        return false;
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
    }
}
