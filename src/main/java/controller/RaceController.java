package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Car;
import util.InputOutputHandler;
import util.RandomGenerator;

public class RaceController {
    private List<Car> cars;
    private List<String> winners;
    private RandomGenerator randomGenerator;

    public RaceController(List<Car> cars) {
        this.cars = cars;
        this.winners = new ArrayList<>();
        this.randomGenerator = new RandomGenerator();
    }

    public void loopThroughCars(int times) {
        InputOutputHandler.printResult();
        for (int i = 0; i < times; i++) {
            executeRandomCars();
            InputOutputHandler.printCars(this.cars);
        }
    }

    public void getWinner() {
        int maxScore = getMaxScore();
        System.out.println("max: " + maxScore);
        for (int i = 0; i < this.cars.size(); i++) {
            addToWinners(this.cars.get(i), maxScore);
        }
        InputOutputHandler.printWinners(this.winners);
    }

    private void addToWinners(Car car, int maxScore) {
        // TODO: maxScore가 0일 경우 예외처리
        if (car.getPosition() == maxScore) {
            this.winners.add(car.getName());
        }
    }

    private void executeRandomCars() {
        for (Car car : this.cars) {
            goOrStop(car);
        }
    }

    private void goOrStop(Car car) {
        if (this.randomGenerator.isGoingForward()) {
            car.goForward();
        }
    }

    private int getMaxScore() {
        Collections.sort(this.cars);
        return this.cars.get(0).getPosition();
    }
}
