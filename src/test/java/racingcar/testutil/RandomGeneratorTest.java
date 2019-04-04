/*
 * RandomGeneratorTest.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.testutil;

import racingcar.util.Constants;
import racingcar.util.RandomGenerator;

public class RandomGeneratorTest extends DefaultTest {
    @Override
    public void test(String[] args) {
        int randomNumber = RandomGenerator.getRandomNumber();
        if (randomNumber >= Constants.NUMBER_LOWER_BOUND
                && randomNumber <= Constants.NUMBER_UPPER_BOUND) {
            correctAnswer++;
        }
        testCount++;
    }
}
