package domain;

import exeption.IncorrectRacerNameException;
import util.CarAdvanceDecider;

public class Car {
    private final static int DEFAULT_TRUE_RATIO = 6;
    private final static int DEFAULT_FALSE_RATIO = 4;
    private final static int DEFAULT_MOVE_POSITION = 1;

    private final static char CAR = '*';
    private final static char TRACE = '-';

    public final static int MAX_LENGTH_RACER_NAME = 5;
    private final String name;

    private int position = 0;

    private CarAdvanceDecider carAdvanceDecider = new CarAdvanceDecider();

    Car(String name) {
        this.name = name;
    }

    int forwardOrStop() {
        return forwardOrStop(DEFAULT_MOVE_POSITION, DEFAULT_TRUE_RATIO, DEFAULT_FALSE_RATIO);
    }

    /* 제시한 확률에 따라 자동차를 전진시키고 위치를 변경한다. */
    int forwardOrStop(int movePosition, int trueRatio, int falseRatio) {
        boolean canForward = carAdvanceDecider.getTrueOrFalseByChance(trueRatio, falseRatio);
        if (canForward) {
            position += movePosition;
        }
        return position;
    }

    String getName() {
        return name;
    }

    boolean isPositionOn(int position) {
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
