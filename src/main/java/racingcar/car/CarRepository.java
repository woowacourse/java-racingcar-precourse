package racingcar.car;

import static racingcar.utils.StringUtils.INITIAL_POSITION;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> saveInOrder(List<Car> cars) {
        this.cars.addAll(cars);
        return cars;
    }

    public List<Car> findAllInOrder() {
        return new ArrayList<>(cars);
    }

    public List<Car> findTopByOrderByPosition() {
        return findByPosition(findMaxPosition());
    }

    private int findMaxPosition() {
        int maxPosition = INITIAL_POSITION;
        for (Car car : cars) {
            if (car.hasFartherPosition(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<Car> findByPosition(int position) {
        List<Car> carsWithCertainPosition = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(position)) {
                carsWithCertainPosition.add(car);
            }
        }
        return carsWithCertainPosition;
    }
}
