package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        if (canMove()) {
            this.position += 1;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND) >= THRESHOLD;
    }
}
