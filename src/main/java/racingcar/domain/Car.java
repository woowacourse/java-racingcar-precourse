package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.utils.Consts.CAR_NAME_LENGTH;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toMessage() {
        String movement = "-".repeat(position);
        return name + " : " + movement;
    }
}
