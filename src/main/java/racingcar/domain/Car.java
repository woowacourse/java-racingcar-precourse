package racingcar.domain;

import java.util.Objects;

import racingcar.domain.generator.FixedFuelGenerator;
import racingcar.domain.generator.FuelGenerator;
import racingcar.domain.generator.RandomFuelGenerator;

public final class Car {

    private static final int MOVE_CONDITION = 4;

    private final Name name;

    private final Position position;

    private final FuelGenerator fuelGenerator;

    public Car(final String name) {
        this(name, 0, new RandomFuelGenerator());
    }

    public Car(final String name, final int fuel) {
        this(name, 0, fuel);
    }

    public Car(final String name, final int position, final int fuel) {
        this(name, position, new FixedFuelGenerator(fuel));
    }

    public Car(final String name, final int position, final FuelGenerator fuelGenerator) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.fuelGenerator = fuelGenerator;
    }

    public Car(final Name name, final Position position, final FuelGenerator fuelGenerator) {
        this.name = name;
        this.position = position;
        this.fuelGenerator = fuelGenerator;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Car move() {
        if (fuelGenerator.generate() >= MOVE_CONDITION) {
            return new Car(name, position.increase(), fuelGenerator);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Car)) { return false; }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) &&
                Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
