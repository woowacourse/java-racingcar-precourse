package controller;

import java.util.List;

import domain.Car;
import util.RandomGenerator;

public class RaceController {
    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public RaceController(List<Car> cars) {
        this.cars = cars;
        this.randomGenerator = new RandomGenerator();
    }

    public void loopThroughCars() {
        for (Car car : this.cars) {
            goOrStop(car);
        }
        printCars();
    }

    private void goOrStop(Car car) {
        if (this.randomGenerator.isGoingForward()) {
            car.goForward();
        }
    }

    private void printCars() {
        for (Car car : this.cars) {
            System.out.println(car);
        }
    }
}
