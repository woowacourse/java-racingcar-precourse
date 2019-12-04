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

    public void executeRace(int times) {
        InputOutputHandler.printResult();
        for (int i = 0; i < times; i++) {
            race();
            InputOutputHandler.printCars(cars);
        }
    }

    private void race() {
        for (Car car : cars) {
            goForwardRandomly(car);
        }
    }

    private void goForwardRandomly(Car car) {
        if (randomGenerator.isGoingForward()) {
            car.goForward();
        }
    }

    public void printWinners() {
        int maxPosition = getMaxPosition();
        if (maxPosition == 0) {
            winnerDoesNotExists();
            return;
        }
        winnerExists(maxPosition);
    }

    private void winnerExists(int maxPosition) {
        for (int i = 0; isEqualToMaxPosition(i, maxPosition); i++) {
            addWinners(cars.get(i), maxPosition);
        }
        InputOutputHandler.printWinners(winners);
    }

    private boolean getPositionOfNth(List<Car> cars, int i, int maxPosition) {
        Car car = cars.get(i);
        return car.getPosition() >= maxPosition;
    }

    private boolean isEqualToMaxPosition(int i, int maxPosition) {
        return i < cars.size() && getPositionOfNth(cars, i, maxPosition);
    }

    private void winnerDoesNotExists() {
        InputOutputHandler.printNoWinners();
    }

    private void addWinners(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private Car getLongestPositionedCar() {
        Collections.sort(cars);
        return cars.get(0);
    }

    private int getMaxPosition() {
        return getLongestPositionedCar().getPosition();
    }
}
