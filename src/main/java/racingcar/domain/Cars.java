package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATE_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름이 중복되었습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void race(Number generator) {
        for (Car car : cars) {
            car.tryMoveForward(generator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validate(List<Car> cars) {
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private boolean isDuplicate(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet())
                .size() != cars.size();
    }
}
