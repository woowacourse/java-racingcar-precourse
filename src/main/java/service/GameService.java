package service;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Car> cars;

    public GameService(String[] carNames) {
        cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void runPhase() {
        for (Car car : cars) {
            car.moveRandomly();
            System.out.println(car);
        }
        System.out.println();
    }

    private Car findOneOfWinners() {
        Car winner = cars.get(0);

        for (Car car : cars) {
            if (winner.compareTo(car) < 0) {
                winner = car;
            }
        }

        return winner;
    }

    private List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();

        Car winner = findOneOfWinners();
        for (Car car : cars) {
            if (winner.compareTo(car) == 0) {
                winners.add(car);
            }
        }

        return winners;
    }
}
