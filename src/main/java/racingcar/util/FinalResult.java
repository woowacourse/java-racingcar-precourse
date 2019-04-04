/*
 * FinalResult.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;

public class FinalResult {
    public static void printFinalResult(ArrayList<Car> cars) {
        int max = 0;

        /* sort by position max to min */
        Collections.sort(cars, Collections.reverseOrder());
        max = cars.get(0).getPos();
        System.out.print(cars.get(0).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getPos() != max) {
                break;
            }
            System.out.print(Constants.NAME_DELIMINATOR
                    + cars.get(i).getName());
        }
        System.out.println(Constants.PRINT_FINAL_RESULT_GUIDE);
    }
}
