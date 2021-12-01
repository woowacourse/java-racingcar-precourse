package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printCurrentCarsPosition(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.position()));
    }
}
