package racingcar.domains.car;

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
        return null;
    }

    public Output getGameStatus() {
        return null;
    }

    public void move() {

    }
}
