package racingcar.domains.car;

import racingcar.domains.output.GameResult;
import racingcar.domains.output.GameStatus;
import racingcar.domains.output.Output;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars getInstanceWithCarNames(List<String> carNames) {
        Car[] cars = carNames.stream()
                .map(Car::new)
                .toArray(Car[]::new);

        return new Cars(Arrays.asList(cars));
    }

    public Output getGameResult() {
        return new GameResult(cars);
    }

    public Output getGameStatus() {
        return new GameStatus(cars);
    }

    public void move() {
        cars.forEach(Car::moveOrNot);
    }
}
