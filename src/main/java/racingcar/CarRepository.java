package racingcar;

import static racingcar.StringConstants.INITIAL_POSITION;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public Car saveInOrder(Car car) {
        cars.add(car);
        return car;
    }

    public List<Car> findAllCarsInOrder() {
        return new ArrayList<>(cars);
    }

    public List<Car> findTopByOrderByPosition() {
        int maxPosition = findMaxPosition();
        return findByPosition(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = INITIAL_POSITION;
        for (Car car : cars) {
            int position = car.getPosition();
            if(car.getPosition() > maxPosition) {
                maxPosition = position;
                continue;
            }
        }
        return maxPosition;
    }
    
    private List<Car> findByPosition(int distance) {
        List<Car> carsWithCertainDistance = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == distance) {
                carsWithCertainDistance.add(car);
            }
        }
        return carsWithCertainDistance;
    }
}
