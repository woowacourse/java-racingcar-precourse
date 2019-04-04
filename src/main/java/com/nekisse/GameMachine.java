package com.nekisse;

import com.nekisse.domain.Car;
import com.nekisse.domain.CarName;

import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    private RandomNumberGenerator randomNumberGenerator;
    private final int inputTryCount;
    private int currentCount;
    private  List<Car> cars;

    public GameMachine(int inputTryCount, List<CarName> carNames, RandomNumberGenerator randomNumberGenerator) {
        this.inputTryCount = inputTryCount;
        this.randomNumberGenerator = randomNumberGenerator;
        this.cars = setupCar(carNames);
    }

    public void runCar() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateRandomNumber());
        }
        currentCount++;
    }

    private List<Car> setupCar(List<CarName> carNames) {
        cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
