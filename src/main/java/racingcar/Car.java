package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_RANGE_MIN_NUMBER = 0;
    private static final int RANDOM_RANGE_MAX_NUMBER = 9;
    private static final int MOVE_THRESHOLD_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if(canMove()) position ++;
    }

    private boolean canMove() {
        int moveNumber = Randoms.pickNumberInRange(RANDOM_RANGE_MIN_NUMBER, RANDOM_RANGE_MAX_NUMBER);

        return moveNumber >= MOVE_THRESHOLD_NUMBER;
    }
}
