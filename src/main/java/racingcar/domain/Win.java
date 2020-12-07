/*
 * Winner.java
 *
 * version 1.0
 *
 * 2020/12/05
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Win {
    private static ArrayList<Car> cars;
    private static int firstValue;

    public Win(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public String[] winner() {
        String[] winnerName = new String[ranking().size()];
        return ranking().toArray(winnerName);
    }

    private ArrayList<String> ranking() {
        ArrayList<String> carNames = new ArrayList<>();
        Collections.sort(cars);
        firstValue = cars.get(0).getPosition();
        for (Car car : cars) {
            if (firstValue == car.getPosition()) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }
}
