package racingcar.car;

import static racingcar.utils.StringUtils.INITIAL_POSITION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);
    }

    private List<Car> findByPosition(int position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .collect(Collectors.toList());
    }
}
