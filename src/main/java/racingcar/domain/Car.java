package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

public class Car {

    public static final int CAR_NAME_LENGTH = 5;
    private static final String POSITION = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        String refined = name.trim();
        validateName(refined);
        this.name = refined;
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
        String movement = POSITION.repeat(position);
        return String.join(" : ", name, movement);
    }
}
