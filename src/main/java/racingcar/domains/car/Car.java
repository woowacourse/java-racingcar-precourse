package racingcar.domains.car;

import utils.RandomUtils;

public class Car {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MOVABLE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot() {
        if (isMovable()) {
            move();
        }
    }

    private void move() {
        position++;
    }

    private boolean isMovable() {
        int randomNumber = RandomUtils.nextInt(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
        return MOVABLE_THRESHOLD <= randomNumber;
    }
}

