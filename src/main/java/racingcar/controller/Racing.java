package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import utils.RandomUtils;

import java.util.Scanner;

public class Racing {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int LEAST_PROGRESS_NUMBER = 4;

    private Cars cars;
    private int trial;
    private InputView inputView;
    private OutputView outputView;

    public Racing(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.cars = new Cars(this.inputView.getCarNames());
        this.trial = inputView.getTrialNumber();
    }

    public void start() {
        for (int i = 0; i < this.trial; i++) {
            turn();
            OutputView.printProgress(this.cars);
        }
    }

    private void turn() {
        for (Car car : this.cars.getCars()) {
            if (getRandomNumber() >= LEAST_PROGRESS_NUMBER) {
                car.progress();
            }
        }
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }
}
