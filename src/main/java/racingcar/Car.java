package racingcar;

import static racingcar.StringConstants.*;

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
        if (!isRightLength(name.length()) || name.contains(" ")) {
            throw new IllegalArgumentException();
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

    // 본 코드에서 사용되지 않으면 삭제되어야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    // 본 코드에서 사용되지 않으면 삭제되어야 함
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
