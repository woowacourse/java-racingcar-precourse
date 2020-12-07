package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> winners) {
        this.cars = winners;
    }

    public static Winners getWinners(List<Car> cars) {
        // todo 개선 필요
        Car winner = cars.stream()
                .max(Car::compareTo)
                .get();

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    public String getNames() {
        return cars.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object obj) {
        Winners winners;
        if (obj instanceof Winners) {
            winners = (Winners) obj;
        } else {
            return false;
        }
        return this.cars.equals(winners.cars);
    }
}
