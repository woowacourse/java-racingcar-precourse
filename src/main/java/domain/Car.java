package domain;

import util.CarAdvanceDecider;

public class Car {
    private final int DEFAULT_TRUE_RATIO = 4;
    private final int DEFAULT_FALSE_RATIO = 6;
    private final int MOVE_POSITION = 1;

    private final String name;
    private int position = 0;

    private CarAdvanceDecider carAdvanceDecider = new CarAdvanceDecider();

    public Car(String name) {
        this.name = name;
    }

    public void fowardOrStop() {
        forwardOrStop(DEFAULT_FALSE_RATIO, DEFAULT_TRUE_RATIO, DEFAULT_FALSE_RATIO);
    }

    public void forwardOrStop(int movePosition, int trueRatio, int falseRatio) {
        boolean canForward = carAdvanceDecider.getTrueOrFalseByChance(trueRatio, falseRatio);
        if(canForward) {
            position += movePosition;
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
