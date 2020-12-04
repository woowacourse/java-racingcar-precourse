package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car moveForwardOrStop(boolean movable) {
        if (movable) {
            return new Car(name, position + 1);
        }

        return this;
    }

    public boolean isEqualPositionTo(int position) {
        return this.position == position;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
}
