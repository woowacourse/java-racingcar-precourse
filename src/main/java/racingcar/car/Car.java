package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = DEFAULT_POSITION;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    
    public void move() {
        if (isMoving()) {
            position++;
        }
    }

    private boolean isMoving() {
        if (Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE) >= MOVE_CONDITION) {
            return true;
        }
        return false;
    }
}