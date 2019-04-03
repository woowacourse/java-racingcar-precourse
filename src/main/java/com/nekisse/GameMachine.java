package com.nekisse;

import com.nekisse.domain.Car;
import com.nekisse.domain.CarName;

import java.util.ArrayList;
import java.util.List;

public class GameMachine {

    private final int inputTryCount;
    private  List<Car> cars;

    public GameMachine(int inputTryCount, List<CarName> carNames) {
        this.inputTryCount = inputTryCount;
        this.cars = setupCar(carNames);
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
