package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int trial;

    public RacingGame(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }
}
