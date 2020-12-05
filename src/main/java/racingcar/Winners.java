package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners getWinners(List<Car> cars) {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .get();

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
