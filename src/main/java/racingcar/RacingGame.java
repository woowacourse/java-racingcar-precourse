/*
 * RacingGame.java
 *
 * version 1.3
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Setting;
import racingcar.domain.Win;
import view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

import static view.InputView.inputNumberOfAttempts;
import static view.OutputView.executionMessage;
import static view.OutputView.finalWinner;

public class RacingGame {
    private int numberOfAttemps = 0;
    ArrayList<Car> cars;

    public void start(Scanner scanner) {
        cars = Setting.initCar(scanner);
        numberOfAttemps = Setting.initNumberOfAttempts(scanner);
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
        Win win = new Win(cars);
        finalWinner(win.winner());
    }
}
