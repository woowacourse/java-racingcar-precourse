package racingcar.domain.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
