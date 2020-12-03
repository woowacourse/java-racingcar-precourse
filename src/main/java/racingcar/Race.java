package racingcar;

import java.util.List;

public class Race {
    private final int attemptNum;
    private final List<Car> cars;

    public Race(List<Car> cars, int attemptNum) {
        this.cars = cars;
        this.attemptNum = attemptNum;
    }


}
