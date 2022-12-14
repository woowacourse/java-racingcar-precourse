package racingcar.model;

import java.util.ArrayList;
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
        validateCarCount(carNames.size());
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }

    private void validateCarCount(int count) {
        if (count < GameRule.CARS_COUNT_LOWER_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CARS_LACK_OF_COUNT);
        }
    }

    public List<CarDTO> moveCars() {
        racingCars.forEach(car -> car.move(numberGenerator.make()));
        return racingCars.stream()
                .map(Car::to)
                .collect(Collectors.toList());
    }
}
