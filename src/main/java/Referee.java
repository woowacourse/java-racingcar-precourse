import domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public List<Car> decideWinners(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toList());
    }

    private Integer getMaxPosition(List<Car> cars) {
        int higgestDistance = 0;
        higgestDistance = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();
        return higgestDistance;
    }
}
