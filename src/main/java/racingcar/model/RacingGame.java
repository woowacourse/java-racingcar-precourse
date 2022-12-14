package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDTO;
import racingcar.model.constants.ErrorMessage;
import racingcar.model.constants.GameRule;
import racingcar.model.domain.Car;

public class RacingGame {
    private final List<Car> racingCars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void enrollCars(List<String> carNames) {
        validateCarNames(carNames);
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < GameRule.CARS_COUNT_LOWER_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CARS_LACK_OF_COUNT);
        }
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(ErrorMessage.CARS_DUPLICATED_NAME);
        }
    }

    public List<CarDTO> moveCars() {
        racingCars.forEach(car -> car.move(numberGenerator.make()));
        return racingCars.stream()
                .map(Car::to)
                .collect(Collectors.toList());
    }
}
