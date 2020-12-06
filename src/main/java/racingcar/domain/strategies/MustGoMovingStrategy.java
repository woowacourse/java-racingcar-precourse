package racingcar.domain.strategies;

import racingcar.domain.Car;

public class MustGoMovingStrategy implements CarMovingStrategy {

    @Override
    public int generate() {
        return Car.BOUNDARY_VALUE;
    }
}
