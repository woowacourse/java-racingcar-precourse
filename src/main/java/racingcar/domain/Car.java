package racingcar.domain;

import racingcar.exception.CarNameLengthException;

public class Car {

    private static final int CAR_NAME_LENGTH = 5;
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
        if(name.length() > CAR_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }
}
