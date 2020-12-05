package racingcar.domain;

import racingcar.domain.generator.FixedFuelGenerator;
import racingcar.domain.generator.FuelGenerator;
import racingcar.domain.generator.RandomFuelGenerator;

public class Car {

    public static final int MOVE_CONDITION = 4;

    private final Name name;

    private final Position position;

    private final FuelGenerator fuelGenerator;

    public Car(String name) {
        this(name, 0, new RandomFuelGenerator());
    }

    public Car(String name, int fuel) {
        this(name, 0, new FixedFuelGenerator(fuel));
    }

    public Car(String name, int position, FuelGenerator fuelGenerator) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.fuelGenerator = fuelGenerator;
    }

    public Car(Name name, Position position, FuelGenerator fuelGenerator) {
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
}
