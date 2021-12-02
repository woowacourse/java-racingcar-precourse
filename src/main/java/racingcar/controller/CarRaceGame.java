package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {
    public void start() {
        Cars cars = new Cars();
        cars.addCar(InputView.printGetCarsNameMessage());
    }
}
