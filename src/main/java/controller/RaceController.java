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

    public void getWinners() {
        int maxPosition = getMaxPosition();
        if (maxPosition == 0) {
            winnerDoesNotExists();
            return;
        }
        winnerExists(maxPosition);
    }

    private void winnerExists(int maxPosition) {
        // TODO: cars를 모두 순회할 것이 아니고 maxPosition보다 작으면 바로 break
        for (int i = 0; i < cars.size(); i++) {
            addWinners(cars.get(i), maxPosition);
        }
        InputOutputHandler.printWinners(winners);
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
