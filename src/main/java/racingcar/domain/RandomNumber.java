/*
 * RandomNumber.java
 *
 * version 1.0
 *
 * 2020/12/04
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain;

import utils.RandomUtils;

public class RandomNumber {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int STANDARD_NUM = 4;

    public static boolean generatedRandom() {
        int randomNumber = RandomUtils.nextInt(MIN_NUM, MAX_NUM);
        if (randomNumber > STANDARD_NUM) {
            return true;
        }
        return false;
    }

}
