package racingcar.domain.strategies;

import racingcar.domain.Car;

public class MustStopMovingStrategy implements CarMovingStrategy {
    private static final int ONE = 1;

    @Override

    public int generate() {
        return Car.BOUNDARY_VALUE - ONE;
    }
}
