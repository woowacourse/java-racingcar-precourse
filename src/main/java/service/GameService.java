package service;

import racingcar.Car;

import java.util.List;

public class GameService {
    private List<Car> cars;

    public GameService(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public void runPhase() {
        for (Car car : this.cars) {
            car.moveRandomly();
            System.out.println(car);
        }
        System.out.println();
    }
}
