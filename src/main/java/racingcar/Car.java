package racingcar;

import java.util.List;

import utils.RandomUtils;

public class Car {
    private static final int READY = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final String MOVING_MARK = "-";

    private final String name;
    private int position = READY;

    public Car(String name) {
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

    public String printHowMuchEachCarMoved() {
        StringBuilder movingResult = new StringBuilder();
        for (int i = 0; i < position; i++) {
            movingResult.append(MOVING_MARK);
        }
        return String.format("%s : %s", name, movingResult.toString());
    }
}
