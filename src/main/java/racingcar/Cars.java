package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = convertStringToCar(carNames);
    }

    private List<Car> convertStringToCar(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
