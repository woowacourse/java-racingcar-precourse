package racingcar.domain;

import java.util.List;

public class Cars {
    private static final int ZERO = 0;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름을 입력해주세요";
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateExistCars(cars);
        this.cars = cars;
    }

    private void validateExistCars(List<Car> cars) {
        if (cars.size() == ZERO) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }
}
