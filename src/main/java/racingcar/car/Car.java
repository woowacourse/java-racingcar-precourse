package racingcar.car;

import static racingcar.utils.StringUtils.*;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = INITIAL_POSITION;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        checkRightLength(name);
        checkNameContainsSpace(name);
    }

    private static void checkRightLength(String name) {
        if (!isRightLength(name.length())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_TOO_LONG_CAR_NAMES_INPUT);
        }
    }

    private static void checkNameContainsSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_CONTAINING_SPACE_CAR_NAMES_INPUT);
        }
    }

    private static boolean isRightLength(int carNameLength) {
        if (MIN_LENGTH_OF_CAR_NAME <= carNameLength && carNameLength <= MAX_LENGTH_OF_CAR_NAME) {
            return true;
        }
        return false;
    }

    public int run(int randomNumber) {
        if (randomNumber >= MIN_NUMBER_TO_CAR_TO_GO) {
            position++;
            return position;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean hasFartherPosition(int otherPosition) {
        if(this.position > otherPosition) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
