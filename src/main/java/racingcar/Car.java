package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    static final int RANDOM_NUMBER_INCLUSIVE_START = 0;
    static final int RANDOM_NUMBER_INCLUSIVE_END = 9;
    static final int MOVE_FORWARD_NUMBER_INCLUSIVE_START = 4;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForwardOrStop() {
        if (generateRandomNumber() >= MOVE_FORWARD_NUMBER_INCLUSIVE_START) {
            position++;
        }
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(RANDOM_NUMBER_INCLUSIVE_START, RANDOM_NUMBER_INCLUSIVE_END);
    }
}
