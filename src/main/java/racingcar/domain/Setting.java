/*
 * Setting.java
 *
 * version 1.1
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain;

import racingcar.domain.validator.CountValidator;
import racingcar.domain.validator.InputValidator;
import view.InputView;

import java.util.ArrayList;
import java.util.Scanner;

public class Setting {
    static ArrayList<Car> cars = new ArrayList<>();

    public static ArrayList<Car> initCar(Scanner scanner) {
        ArrayList<String> carNames = InputValidator.filterCarName(initCarName(scanner));
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public static int initNumberOfAttempts(Scanner scanner) {
        return InputValidator.filterNumberOfAttempts(InputView.inputNumberOfAttempts(scanner));
    }

    private static ArrayList<String> initCarName(Scanner scanner) {
        ArrayList<String> carNameList = new ArrayList<>();
        String[] carNames = InputView.inputCarName(scanner);
        for (String carName : carNames) {
            carNameList.add(carName);
        }
        return carNameList;
    }
}
