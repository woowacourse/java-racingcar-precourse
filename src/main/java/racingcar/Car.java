package racingcar;

import ui.Output;
import utils.RandomUtils;

public class Car {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int ONE_STEP = 1;
    private static final int MOVABLE_STARTING_NUMBER = 4;
    private static final int STARTING_NUMBER_OF_INVALID_NAME_LENGTH = 6;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move() {
        int movingDistance = getRandomNumber();
        if (movingDistance >= MOVABLE_STARTING_NUMBER) {
            position += ONE_STEP;
        }
        Output.printResult(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() >= STARTING_NUMBER_OF_INVALID_NAME_LENGTH) {
            throw new IllegalArgumentException(
                ErrorMessage.NAME_LENGTH_SHOULD_BE_SMALLER_THAN_FIVE);
        }
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_NUMBER, END_NUMBER);
    }
}
