package racingcar;

import static racingcar.StringConstants.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.StringConstants.MIN_LENGTH_OF_CAR_NAME;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

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

    // 본 코드에서 사용되지 않으면 삭제되어야 함
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
