package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Constants.*;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarAmount(cars);
        validateSameName(cars);
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public List<Car> findWinners() {
        return findMaxPositionCars(findMaxPosition());
    }

    private void validateCarAmount(List<Car> cars) {

        if (cars.size() < MIN_TOTAL_CARS_AMOUNT) {
            throw new IllegalArgumentException(ERROR_ONLY_ONE_CAR);
        }

    }

    private void validateSameName(List<Car> cars) {

        if (cars.size() != cars.stream().map(Car::getName).distinct().count()) {
            throw new IllegalArgumentException(ERROR_SAME_NAME_CAR);
        }

    }

    private Integer findMaxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(POSITION_INIT_VALUE);
    }

    private List<Car> findMaxPositionCars(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}