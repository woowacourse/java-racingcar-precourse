package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private static final String BASE_SPLIT = ",";

    public static List<Car> saveCarList(String input) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = input.split(BASE_SPLIT);

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public static void movePosition(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).carMove();
        }
    }
}
