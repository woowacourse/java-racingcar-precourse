package racingcar.domain;

import java.util.Objects;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.CarNameNullPointException;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameNull(name);
        checkNameLength(name);
        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new CarNameLengthException();
        }
    }

    private static void checkNameNull(String name) {
        if (Objects.isNull(name)) {
            throw new CarNameNullPointException();
        }
    }
}
