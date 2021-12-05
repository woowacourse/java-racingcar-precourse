package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    public static List<Car> saveCarList(String input){
        List<Car> carList = new ArrayList<>();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}
