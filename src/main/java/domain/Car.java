package domain;

import util.CarAdvanceDecider;

public class Car {
    private final int DEFAULT_TRUE_RATIO = 6;
    private final int DEFAULT_FALSE_RATIO = 4;
    private final int DEFAULT_MOVE_POSITION = 1;

    private final char CAR = '*';
    private final char TRACE = '-';

    private final String name;
    private int position = 0;

    private CarAdvanceDecider carAdvanceDecider = new CarAdvanceDecider();

    Car(String name) {
        this.name = name;
    }

    int forwardOrStop() {
        return forwardOrStop(DEFAULT_MOVE_POSITION, DEFAULT_TRUE_RATIO, DEFAULT_FALSE_RATIO);
    }

    int forwardOrStop(int movePosition, int trueRatio, int falseRatio) {
        boolean canForward = carAdvanceDecider.getTrueOrFalseByChance(trueRatio, falseRatio);
        if (canForward) {
            position += movePosition;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isPositionOn(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        /* position이 0일 때, 아예 출력을 안하는지 한칸을 출력하는지 요구사항에서는 불명확.
         * NOTE: 0일때 출력하는 것으로 구현. 자동차의 궤적과 자동차 본체를 나누에 출력한다. */
        StringBuilder result = new StringBuilder(name + ":");
        for (int i = 0; i < position - 1; i++) {
            result.append(TRACE);
        }
        return result.toString() + CAR;
    }
}
