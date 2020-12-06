package racingcar;

import java.util.List;

import utils.RandomUtils;

public class Car {
    private static final int READY = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;

    private final String name;
    private int position = READY;

    public Car(String name) {
        CarValidator.validateCarName(name);
        this.name = name;
    }

    public void moveOrStop() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return (makeRandomNumber() >= MOVE_STANDARD);
    }

    private int makeRandomNumber() {
        return RandomUtils.nextInt(RANGE_START, RANGE_END);
    }

    public int getPositionIfBiggerThan(int highestPosition) {
        return Math.max(position, highestPosition);
    }

    public boolean isWinner(int highestPosition) {
        if (position == highestPosition) {
            return true;
        }
        return false;
    }

    public void addNameToWinner(List<String> winner) {
        winner.add(name);
    }
}
