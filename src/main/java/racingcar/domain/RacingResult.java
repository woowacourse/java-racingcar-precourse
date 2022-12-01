package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResult {
    private final Map<String, Integer> result;

    public RacingResult(List<Car> cars) {
        result = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<String> getCarNames() {
        return new ArrayList<>(result.keySet());
    }

    public int getPosition(String carName) {
        return result.get(carName);
    }
}
