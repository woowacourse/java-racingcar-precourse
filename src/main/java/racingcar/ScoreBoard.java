package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ScoreBoard {
    private ArrayList<Car> cars;

    public ScoreBoard(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getResult() {
        return cars;
    }

    public ArrayList<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getWinner(cars).getPosition())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Car getWinner(ArrayList<Car> cars) {
        return Collections.max(cars, Comparator.comparingInt(Car::getPosition));
    }
}
