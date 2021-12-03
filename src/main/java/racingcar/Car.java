package racingcar;

import racingcar.util.RandomNumberGenerator;

import static racingcar.constant.Constraint.*;

public class Car {
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
        return RandomNumberGenerator.getRandomNumber() >= MOVING_FORWARD;
    }
}
