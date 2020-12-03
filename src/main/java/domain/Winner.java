package domain;

import domain.racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public static List<String> makeWinners(List<Car> cars) {
        Integer winnerCount = cars.stream().mapToInt(Car::getPosition).boxed().max(Integer::compareTo).get();
        return cars.stream().filter(car -> car.getPosition() == winnerCount).map(Car::getName).collect(Collectors.toList());
    }
}
