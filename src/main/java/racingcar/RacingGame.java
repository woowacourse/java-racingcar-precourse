/*
 * RacingGame.java
 *
 * version 1.1
 *
 * 2020/12/05
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Setting;
import view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

import static view.InputView.inputNumberOfAttempts;
import static view.OutputView.executionMessage;

public class RacingGame {
    private int numberOfAttemps = 0;
    ArrayList<Car> cars = new ArrayList<>();

    public void start(Scanner scanner) {
        cars = Setting.initCar(scanner);
        numberOfAttemps = inputNumberOfAttempts(scanner);
        executionMessage();
        racing();

    }

    private void oneLap() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    private void racing() {
        for (int i = 0; i < numberOfAttemps; i++) {
            oneLap();
            OutputView.executionResult(cars);
            System.out.println();
        }
    }
}
