/*
 * RandomGenerator.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(Constants.NUMBER_UPPER_BOUND + 1)
                + Constants.NUMBER_LOWER_BOUND;
    }
}
