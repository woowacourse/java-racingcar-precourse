package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String ERROR_ONLY_ONE_CAR = "[ERROR] 2대 이상의 자동차의 이름을 입력해야한다.";
    public static final String ERROR_SAME_NAME_CAR = "[ERROR] 서로 다른 이름의 자동차 이름을 입력해야 한다.";
    public static final int MIN_POSITION_VALUE = 0;
    public static final int MIN_TOTAL_CARS_AMOUNT = 2;
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
                .orElse(MIN_POSITION_VALUE);
    }

    private List<Car> findMaxPositionCars(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}