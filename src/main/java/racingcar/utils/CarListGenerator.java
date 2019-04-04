package racingcar.utils;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListGenerator {

    public static List<Car> generate(String carNames) {
        return toList(split(carNames));
    }

    private static String[] split(String carNames) {
        return carNames.split(",");
    }

    private static List<Car> toList(String[] carNames) {
        List<Car> cars = new ArrayList();
        for (String carName : carNames)
            cars.add(new Car(carName));

        return cars;
    }
}
