package model.car;

import java.util.Objects;

import model.car.vo.CarName;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private final CarName name;
    private int position;

    public Car(final String name) {
        this.name = new CarName(name);
        position = INITIAL_POSITION;
    }

    public void move(final boolean move) {
        if (move) {
            position++;
        }
    }

    public boolean hasHigherPositionThan(final Car another) {
        return this.position >= another.position;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
