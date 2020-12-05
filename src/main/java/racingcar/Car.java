package racingcar;

import utils.RandomUtils;

import java.util.Objects;

public class Car {
    private static final int SINGLE_DIGIT_MIN = 0;
    private static final int SINGLE_DIGIT_MAX = 9;
    private static final int STOP_LIMIT = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Car) {
            Car anotherCar = (Car) object;
            return name.equals(anotherCar.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void moveCar() {
        if (isPossibleMove()) {
            position++;
        }
    }

    private boolean isPossibleMove() {
        int movementState = RandomUtils.nextInt(SINGLE_DIGIT_MIN, SINGLE_DIGIT_MAX);
        return movementState > STOP_LIMIT;
    }

}
