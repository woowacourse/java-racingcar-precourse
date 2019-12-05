package controller;

import domain.Car;
import view.Input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private int round;
    private List<Car> cars;

    public Game() {
        this.cars = setCars(new Input().asCarNames());
        this.round = new Input().asRounds();
    }

    public void start() {
    }

    public List<Car> setCars(List<String> names) {
        return names.stream().map(Car::new).collect(Collectors.toList());
    }
}
