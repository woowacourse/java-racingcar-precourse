package controller;

import domain.Car;
import view.Input;
import view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int round;
    private List<Car> cars;

    public Game() {
        this.cars = setCars(new Input().asCarNames());
        this.round = new Input().asRounds();
    }

    public List<Car> setCars(List<String> names) {
        return names.stream().map(Car::new).collect(Collectors.toList());
    }

    public void start() {
        while (round > 0) {
            System.out.println();
            cars.forEach(Car::goForward);
            cars.stream().map(Car::toString).forEach(System.out::println);
            round--;
        }
        Output.showWinners(getWinner());
    }

    public int getWinnerScore() {
        return cars.stream().map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<String> getWinner() {
        return cars.stream().filter(x -> x.getPosition() == getWinnerScore())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
