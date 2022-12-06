package racingcar.domain;

import racingcar.exception.CarNameLengthException;

public class Car {

    private static final int CAR_NAME_LENGTH = 5;
    private static final int MOVABLE_MIN_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }

    public void move(CarMoveNumberGenerator carMoveNumberGenerator) {
        final int number = carMoveNumberGenerator.generate();

        if (number >= MOVABLE_MIN_NUMBER) {
            position++;
        }
    }
}
