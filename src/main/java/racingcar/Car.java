package racingcar;

import java.util.Objects;
import racingcar.util.Assertions;

public class Car {
    private static final int NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        Assertions.throwExceptionIsTrue(name.length() > NAME_LENGTH, ErrorInfo.LENGTH);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car)o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
