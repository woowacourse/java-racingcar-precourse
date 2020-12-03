package controller;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CarController {

    private List<Car> cars;

    public CarController() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {

        // 혹시나 모르는 실수를 방지하게 위해
        if (!checkDuplication(car.getName())) {
            return;
        }

        cars.add(car);
    }

    private boolean checkDuplication(String name) {
        return cars.stream().noneMatch(car -> car.getName().equals(name));
    }

    public Car getCar(String name) {
        return cars.stream().filter(c -> c.getName().equals(name)).findAny().orElse(null);
    }

    public OptionalInt getCarPosition(String name) {

        Car car = getCar(name);

        if (car == null) {
            return OptionalInt.empty();
        }

        return OptionalInt.of(car.getPosition());
    }

    public void moveCar(String name) {
        Car car = getCar(name);

        if (car == null) {
            return;
        }

        car.moveForward();
    }


}
