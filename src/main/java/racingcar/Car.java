package racingcar;

import java.util.List;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

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
        return (makeRandomNumber() >= 4);
    }

    private int makeRandomNumber() {
        return RandomUtils.nextInt(0, 9);
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
