/*
 * RacingGame.java    1.00 20190401
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package domain;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RACING_NUM = 1;

    private Car[] cars;

    public void play() {
        int racingNum;

        setCars();
        racingNum = getRacingNum();

        System.out.println("\n실행 결과");
        for (int i = 0; i < racingNum; i++) {
            doRace();
            System.out.println();
        }
    }

    private void doRace() {
        for (Car car : cars) {
            car.race();
            System.out.println(car.getString());
        }
    }

    private int getRacingNum() {
        int num;

        do {
            System.out.println("시도할 회수는 몇회인가요?");
            num = UserInput.getInteger();
        } while (num < MIN_RACING_NUM);

        return num;
    }

    private Car[] setCars() {
        String[] names = getNames();
        cars = new Car[names.length];
        int i = 0;

        for (String name : names) {
            cars[i++] = new Car(name);
        }

        return cars;
    }

    private String[] getNames() {
        String input;
        String[] names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = UserInput.getString();
            names = input.split(",");
        } while (!validateNames(names));

        return names;
    }

    private boolean validateNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            if ((name.length() > MAX_NAME_LENGTH) || (uniqueNames.contains(name))) {
                return false;
            }
            uniqueNames.add(name);
        }

        return true;
    }
}