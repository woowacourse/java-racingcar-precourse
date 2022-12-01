package racingcar.domain;

import java.util.List;
import racingcar.util.RacingNumberGenerator;
import racingcar.util.RacingRandomNumberGenerator;

public class RacingGame {
    private Road road;
    private List<Car> cars;
    private RacingNumberGenerator numberGenerator;

    public RacingGame(List<Car> cars) {
        this.road = new Road();
        this.numberGenerator = new RacingRandomNumberGenerator();
        this.cars = cars;
    }

    public RacingResult play() {
        for (Car car : cars) {
            int number = numberGenerator.generate();
            road.move(car, number);
        }
        return new RacingResult(cars);
    }
}
