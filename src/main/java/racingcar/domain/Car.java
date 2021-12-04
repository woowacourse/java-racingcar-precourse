package racingcar.domain;

import racingcar.exception.CarNameLengthException;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new CarNameLengthException();
        }
    }
}
