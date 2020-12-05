package racingcar.domain;

public class FixedFuelGenerator implements FuelGenerator {

    private final int fuel;

    public FixedFuelGenerator(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public int generate() {
        return fuel;
    }
}
