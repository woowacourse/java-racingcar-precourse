package racingcar.domains.car;

import racingcar.domains.output.GameResult;
import racingcar.domains.output.GameStatus;
import racingcar.domains.output.Output;

import java.util.Arrays;
import java.util.List;

public class CarGroup {
    private List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup getInstanceWithCarNames(List<String> carNames) {
        Car[] cars = carNames.stream()
                .map(Car::new)
                .toArray(Car[]::new);

        return new CarGroup(Arrays.asList(cars));
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
