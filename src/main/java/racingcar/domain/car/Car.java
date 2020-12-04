package racingcar.domain.car;

import racingcar.domain.exception.CarNameLengthException;

public class Car {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
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
}
