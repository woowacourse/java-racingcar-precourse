/*
 * Game.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int trial;

    public static void getGameSettings() {
        boolean validName = false;
        Scanner scan = new Scanner(System.in);

        System.out.println(Constants.GET_CAR_NAME_GUIDE);
        validName = getCarNames(scan);
        while (!validName) {
            System.out.println(Constants.CAR_COUNT_WARNING);
            validName = getCarNames(scan);
        }

        System.out.println(Constants.GET_TRIAL_NUMBER_GUIDE);
        getTrialNumber(scan);

        scan.close();
    }

    public static void playGame() {
        for (int i = 0; i < trial; i++) {
            race();
            printRoundResult();
        }
        FinalResult.printFinalResult(cars);
    }

    private static boolean getCarNames(Scanner scan) {
        String names = scan.nextLine();
        StringTokenizer nameToken = new StringTokenizer(names,
                Constants.NAME_DELIMINATOR);
        validateCarNames(nameToken);
        return !cars.isEmpty(); // check if there is more than one valid name
    }

    private static void validateCarNames(StringTokenizer nameToken) {
        String carName;
        ArrayList<String> carNames = new ArrayList<>(); // to check the same name
        while (nameToken.hasMoreTokens()) {
            carName = nameToken.nextToken().trim();
            if (!InputChecker.checkCarName(carName) || carNames.contains(carName)) {
                cars.clear();
                return;
            }
            Car carNow = new Car(carName);
            cars.add(carNow);
            carNames.add(carName);
        }
    }

    private static void getTrialNumber(Scanner scan) {
        int tempTrial = scan.nextInt();

        while (!InputChecker.checkTrialNumber(tempTrial)) {
            tempTrial = scan.nextInt();
        }
        trial = tempTrial;
    }

    private static void race() {
        for (Car c : cars) {
            c.runRandomly();
        }
    }

    private static void printRoundResult() {
        for (Car c : cars) {
            c.visualizePosition();
        }
        System.out.println();
    }
}
