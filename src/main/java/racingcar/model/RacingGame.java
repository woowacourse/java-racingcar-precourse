package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDTO;
import racingcar.dto.CarStatusDTO;
import racingcar.model.domain.Car;
import racingcar.model.domain.RacingCars;

public class RacingGame {
    private final RacingCars racingCars = new RacingCars();
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void enrollCars(List<String> carNames) {
        racingCars.addCars(carNames);
    }

    public List<CarStatusDTO> repeatMovingCars(int moveCount) {
        List<CarStatusDTO> carStatuses = new ArrayList<>();
        for (int count = 0; count < moveCount; count++) {
            carStatuses.add(new CarStatusDTO(moveCars()));
        }
        return carStatuses;
    }

    private List<CarDTO> moveCars() {
        racingCars.race(numberGenerator);
        List<Car> cars = racingCars.cars();
        return cars.stream()
                .map(Car::to)
                .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : racingCars.cars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        racingCars.findCarsAtPosition(maxPosition).forEach(car -> winnerNames.add(car.getName()));
        return winnerNames;
    }
}
