package racingcar.domain.car;

import java.util.Objects;

public class Car {

    public static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;
    private CarMoveStrategy carMoveStrategy;

    private Car(final String name, final int position, final CarMoveStrategy carMoveStrategy) {
        this.name = name;
        this.position = position;
        this.carMoveStrategy = carMoveStrategy;
    }

    public static Car of(final String name, final CarMoveStrategy carMoveStrategy) {
        return new Car(name, DEFAULT_POSITION, carMoveStrategy);
    }

    public void move(final int value) {
        if (carMoveStrategy.isPossibleMove(value)) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position &&
            Objects.equals(name, car.name) &&
            Objects.equals(carMoveStrategy, car.carMoveStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, carMoveStrategy);
    }
}
