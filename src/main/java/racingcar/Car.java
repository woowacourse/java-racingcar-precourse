package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private final String name;
    private final int CONDITION_TO_MOVE = 4;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return pickRandomNumber() >= CONDITION_TO_MOVE;
    }

    private int pickRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
