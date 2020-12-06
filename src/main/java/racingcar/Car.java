package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    // 추가 기능 구현
    private static final int RANDOM_NUMBER_INCLUSIVE_START = 0;
    private static final int RANDOM_NUMBER_INCLUSIVE_END = 9;
    private static final int MOVE_FORWARD_NUMBER_INCLUSIVE_START = 4;
    private static final int CAR_NAME_LENGTH_INCLUSIVE_START = 1;
    private static final int CAR_NAME_LENGTH_INCLUSIVE_END = 5;
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSGAE_END_NAME_ISINBOUND = "경주할 자동차 이름은 1글자 이상, 5글자 이하여야 한다.";

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateLength(String name) {
        int nameLength = name.length();
        if (name == null || nameLength > CAR_NAME_LENGTH_INCLUSIVE_END || nameLength < CAR_NAME_LENGTH_INCLUSIVE_START) {
            throw new IllegalArgumentException(ERROR_MESSAGE_START + ERROR_MESSGAE_END_NAME_ISINBOUND);
        }
    }

    public void moveForwardOrStop() {
        if (createRandomNumber() >= MOVE_FORWARD_NUMBER_INCLUSIVE_START) {
            position++;
        }
    }

    private int createRandomNumber() {
        return RandomUtils.nextInt(RANDOM_NUMBER_INCLUSIVE_START, RANDOM_NUMBER_INCLUSIVE_END);
    }
}
