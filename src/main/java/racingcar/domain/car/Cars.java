package racingcar.domain.car;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAME_NOT_DUPLICATED_MESSAGE = "자동차의 이름은 중복되면 안됩니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        Set<Car> distinctCars = new HashSet<>(cars);
        if (cars.size() != distinctCars.size()) {
            throw new IllegalArgumentException(CAR_NAME_NOT_DUPLICATED_MESSAGE);
        }
    }

    public Cars moveAllForwardOrStop(CarMovement carMovement) {
        List<Car> movedCars = this.cars.stream()
                .map(car -> car.moveForwardOrStop(carMovement.isMovable()))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(cars);
    }
}
