package racingcar.domain.car;

import racingcar.domain.dto.CarDto;
import racingcar.domain.exception.CannotFindWinnerCarException;
import racingcar.domain.exception.CarNameException;
import racingcar.domain.strategy.MovingStrategy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames, MovingStrategy movingStrategy) {
        validateDuplication(carNames);
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validateDuplication(List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        if (distinctCarNames.size() != carNames.size()) {
            throw CarNameException.ofDuplicatedNames();
        }
    }

    public void move() {
        this.cars.forEach(Car::move);
    }

    public List<String> getWinnerCarNames() {
        Car maximumPositionCar = findMaximumPositionCar();
        return this.cars.stream()
                .filter(car -> car.isSamePosition(maximumPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaximumPositionCar() {
        return this.cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(CannotFindWinnerCarException::new);
    }

    public List<CarDto> getCarDtos() {
        return this.cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
