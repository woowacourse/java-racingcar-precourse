import domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    List<Car> decideWinners(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        List<Car> winners = cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toList());
        return winners;
    }

    private Integer getMaxPosition(List<Car> cars) {
        Car winner = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        return winner.getPosition();
    }
}
