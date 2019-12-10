package game;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameDecider {

    private static final int DEFAULT_POSITION = 0;

    public List<String> pickWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<Car> carsInMaxPosition = pickCarsInSamePosition(cars, maxPosition);
        return carsInMaxPosition.stream().map(Car::getName).collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        int first = DEFAULT_POSITION;
        for (Car car : cars) {
            if (car.getPosition() > first) {
                first = car.getPosition();
            }
        }
        return first;
    }

    private List<Car> pickCarsInSamePosition(List<Car> cars, int position) {
        return cars.stream().filter(car -> car.isSamePosition(position)).collect(Collectors.toList());
    }

}
