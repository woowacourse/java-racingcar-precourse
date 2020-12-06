package racingcar.controller.view;

import racingcar.domain.car.Car;

import java.util.List;

public interface ViewController {
    void recordCarsPosition(String positon);
    void recordWinner(List<Car> winners);
    void printResult();
}
    