package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.NumberGenerator;
import racingcar.model.constants.ErrorMessage;
import racingcar.model.constants.GameRule;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < GameRule.CARS_COUNT_LOWER_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CARS_LACK_OF_COUNT);
        }
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(ErrorMessage.CARS_DUPLICATED_NAME);
        }
    }

    public void addCars(List<String> carNames) {
        validateCarNames(carNames);
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public void race(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.make()));
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findCarsAtPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
