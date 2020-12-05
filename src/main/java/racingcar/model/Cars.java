package racingcar.model;

import java.util.List;

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
}