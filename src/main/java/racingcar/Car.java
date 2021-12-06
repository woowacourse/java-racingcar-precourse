package racingcar;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final int MOVE_FORWARD_ONCE = 1;
    private static final int NONE = 0;

    private final String name;
    private int position = NONE;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStopCar() {
        if (canCarMoveForward()) {
            position += MOVE_FORWARD_ONCE;
        }
    }

    private boolean canCarMoveForward() {
        return RandomNumberGenerator.getRandomNumber() >= MOVE_FORWARD_CONDITION;
    }
}
