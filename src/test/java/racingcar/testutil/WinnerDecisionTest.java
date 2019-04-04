/*
 * WinnerDecisionTest.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.testutil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.lang.System;

import racingcar.util.Car;
import racingcar.util.FinalResult;

public class WinnerDecisionTest extends DefaultTest {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int carNumber;

    /**
     * @param args : [0] number of cars n
     *             [1 ... n] name of cars
     *             [n+1 ... 2n] final position of each cars
     *             [2n+1] expected result
     */
    @Override
    public void test(String[] args) {
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(baos);

        initializeCars(args);

        System.setOut(printstream);
        FinalResult.printFinalResult(cars);
        System.setOut(original);

        if (baos.toString().equals(args[carNumber * 2 + 1])) {
            correctAnswer++;
        }
        testCount++;
    }

    private void initializeCars(String[] args) {
        carNumber = Integer.parseInt(args[0]);
        for (int i = 0; i < carNumber; i++) {
            Car carNow = new Car(args[i + 1]);
            carNow.runByInput(Integer.parseInt(args[i + carNumber + 1]));
            cars.add(carNow);
        }
    }
}
