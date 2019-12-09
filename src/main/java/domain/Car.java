package domain;

import java.util.Objects;

public class Car {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        name = name.trim();
        if (isOverFiveLettersName(name)) {
            throw new IllegalArgumentException(String.format("※자동차 이름은 %d자 이하여야 합니다.", CAR_NAME_MAX_LENGTH));
        }
        this.name = name;
    }

    // 추가 기능 구현
    private static boolean isOverFiveLettersName(String carName) {
        return CAR_NAME_MAX_LENGTH < carName.length();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return this.getName().equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
