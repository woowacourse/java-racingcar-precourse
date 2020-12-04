package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {
    private List<Car> cars;

    public ScoreBoard(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getResult() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                   .filter(car -> car.getPosition() == getWinner(cars).getPosition())
                   .collect(Collectors.toCollection(ArrayList::new));
    }

    private Car getWinner(List<Car> cars) {
        return Collections.max(cars, Comparator.comparingInt(Car::getPosition));
    }
}
