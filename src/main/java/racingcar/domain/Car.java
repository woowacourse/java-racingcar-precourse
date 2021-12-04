package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVE_STANDARD_VALUE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void moveStepForward() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    private boolean hasNext() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MOVE_STANDARD_VALUE;
    }

    public void drive(int distance) {
        for (int i = 0; distance > i; i++) {
            if (hasNext()) {
                moveStepForward();
            }
        }
    }

    public int getPosition() {
        return position;
    }
}