package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.domain.exception.CarNameValidator;
import racingcar.domain.exception.Validator;
import racingcar.view.Output;

public class Cars {
    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String names) {
        cars = new ArrayList<>();
        CarNameValidator validator = new Validator();
        String[] nameArr = names.split(DELIMITER);
        if (validator.isAllValid(nameArr)) {
            for (String name : nameArr) {
                cars.add(createCar(name));
            }
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    public void play() {
        for (Car car : cars) {
            car.drive();
        }
        recordingScore();
    }

    private void recordingScore() {
        Output.roundResult(cars);
    }

    public List<String> findWinnerCars() {
        Car maxPosition = findMaxPosition();
        return findSamePosition(maxPosition);
    }

    private Car findMaxPosition() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(() -> new NoSuchElementException(Output.maxPositionCarErrorMessage()));
    }

    private List<String> findSamePosition(Car maxPositionCar) {
        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPositionCar))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
