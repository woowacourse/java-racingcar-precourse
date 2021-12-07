package racingcar.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.model.Car.MIN_POSITION;

public class CarList {
    private final List<Car> carList;

    public CarList(LinkedHashSet<String> carNamesLinkedHashSet) {
        carList = carNamesLinkedHashSet.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAllCars() {
        carList.forEach(Car::moveOrStopCar);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> findWinner() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }
}
