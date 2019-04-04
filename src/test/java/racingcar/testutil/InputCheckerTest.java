/*
 * InputCheckerTest.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.testutil;

import racingcar.util.InputChecker;

public class InputCheckerTest extends DefaultTest {

    /**
     * @param args : [0] what to test, name or number
     *             [1] user input mock
     *             [2] expected result
     */
    @Override
    public void test(String[] args) {
        boolean result = false;

        if (args[0].equals("name")) {
            result = InputChecker.checkCarName(args[1]);
        } else if (args[0].equals("number")) {
            result = InputChecker.checkTrialNumber(Integer.parseInt(args[1]));
        }

        if (result == Boolean.valueOf(args[2])) {
            correctAnswer++;
        }
        testCount++;
    }
}
