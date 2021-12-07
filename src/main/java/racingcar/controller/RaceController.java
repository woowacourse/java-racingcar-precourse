package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    public void start() {
        Cars cars = new Cars(getCars());
        cars.race(getAttempts());
        printWinner(cars);
    }

    private List<Car> getCars() {
        String[] carNames = InputView.getCarNames();

        return Arrays.stream(carNames)
                .map(e -> new Car(e))
                .collect(Collectors.toList());
    }

    private int getAttempts() {
        return InputView.getAttempt();
    }

    private void printWinner(Cars cars) {
        ResultView.printWinner(cars.getWinners());
    }
}
