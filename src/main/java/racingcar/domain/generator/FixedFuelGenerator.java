package racingcar.domain.generator;

public final class FixedFuelGenerator implements FuelGenerator {

    private final int fuel;

    public FixedFuelGenerator(final int fuel) {
        this.fuel = fuel;
    }

    @Override
    public int generate() {
        return fuel;
    }
}
