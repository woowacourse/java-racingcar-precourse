import java.util.*;

public class RacingCars {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateNames(cars);
        this.cars = cars;
    }

    private void validateNames(List<Car> cars) {
        for (Car car : cars) {
            validateName(car);
        }
    }

    private void validateName(Car car) {
        if (car.nameLongerThan(MAX_LENGTH_OF_CAR_NAME)) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}
