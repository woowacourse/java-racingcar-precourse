package domain;

import util.CarAdvanceDecider;

public class Car {
    private final int DEFAULT_TRUE_RATIO = 4;
    private final int DEFAULT_FALSE_RATIO = 6;
    private final int DEFAULT_MOVE_POSITION = 1;

    private final char CAR = '*';
    private final char TRACE = '-';

    private final String name;
    private int position = 0;

    private CarAdvanceDecider carAdvanceDecider = new CarAdvanceDecider();

    public Car(String name) {
        this.name = name;
    }

    public int forwardOrStop() {
        return forwardOrStop(DEFAULT_MOVE_POSITION, DEFAULT_TRUE_RATIO, DEFAULT_FALSE_RATIO);
    }

    public int forwardOrStop(int movePosition, int trueRatio, int falseRatio) {
        boolean canForward = carAdvanceDecider.getTrueOrFalseByChance(trueRatio, falseRatio);
        if (canForward) {
            position += movePosition;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + ":");
        for (int i = 0; i < position - 1; i++) {
            result.append(TRACE);
        }
        return result.toString() + CAR;
    }
}
