package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final int CAR_NAME_MIN_LENGTH_LIMIT = 1;
    private static final int CAR_NAME_MAX_LENGTH_LIMIT = 5;
    private static final String CAR_NAME_LENGTH_OVER_MESSAGE = "[ERROR] 자동차의 이름은 최소 1글자 최대 5글자만 가능합니다.";
    private static final String BLANK = " ";
    private static final String CAR_NAME_NOT_CONTAIN_BLANK_MESSAGE = "[ERROR] 자동차 이름은 공백을 포함할 수 없습니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCar(name);
        this.name = name;
    }

    private void validateCar(String name) {
        validateCarNameLength(name);
        validateCarNameContainBlank(name);
    }

    private void validateCarNameContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(CAR_NAME_NOT_CONTAIN_BLANK_MESSAGE);
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH_LIMIT || name.length() < CAR_NAME_MIN_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public void moveForwardOrStop(boolean movable) {
        if (movable) {
            this.position++;
        }
    }
}
