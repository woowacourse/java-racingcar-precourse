package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
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

    public RacingResult getWinner() {
        Integer maxPosition = getMaxPosition();

        List<Car> winner = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return new RacingResult(winner);
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }
}
