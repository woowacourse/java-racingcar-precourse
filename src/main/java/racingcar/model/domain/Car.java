package racingcar.model.domain;

import racingcar.model.constants.ErrorMessage;
import racingcar.model.constants.GameRule;

public class Car {
    private final String name;
    private final int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > GameRule.NAME_LENGTH_UPPER_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
