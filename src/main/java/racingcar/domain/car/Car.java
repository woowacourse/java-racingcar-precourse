package racingcar.domain.car;

import racingcar.domain.exception.CarNameLengthException;
import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    private final MovingStrategy movingStrategy;
    private int position = 0;

    public Car(String name, MovingStrategy movingStrategy) {
        validateCarName(name);
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    private void validateCarName(String name) {
        if (name == null) {
            throw new CarNameLengthException();
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_CAR_NAME_LENGTH || trimNameLength > MAXIMUM_CAR_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }

    public void move() {
        if (this.movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car targetCar) {
        return this.position == targetCar.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
