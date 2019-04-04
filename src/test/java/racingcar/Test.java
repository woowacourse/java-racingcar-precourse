/*
 * Test.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar;

import racingcar.testutil.WinnerDecisionTest;
import racingcar.testutil.InputCheckerTest;
import racingcar.testutil.RandomGeneratorTest;

/**
 * Test class is a test sheet user writes manually.
 * Three kinds of test are available.
 */
public class Test {
    public static void main(String[] args) {

        /* Test if input validation is done correctly. */
        testInputChecker();

        /* Test if random number is generated correctly. */
        testRandomGenerator();

        /* Test if final result is printed correctly. */
        testWinnerDecision();
    }

    private static void testInputChecker() {
        InputCheckerTest inputCheckerTest = new InputCheckerTest();
        inputCheckerTest.test(new String[]{"name", "", "false"});
        inputCheckerTest.test(new String[]{"name", "a", "true"});
        inputCheckerTest.test(new String[]{"name", "alice", "true"});
        inputCheckerTest.test(new String[]{"name", "alice ", "true"});
        inputCheckerTest.test(new String[]{"name", "myname", "false"});
        inputCheckerTest.test(new String[]{"number", "-1", "false"});
        inputCheckerTest.test(new String[]{"number", "0", "false"});
        inputCheckerTest.test(new String[]{"number", "1", "true"});
        inputCheckerTest.printResult();
    }

    private static void testRandomGenerator() {
        RandomGeneratorTest randomGeneratorTest = new RandomGeneratorTest();
        for (int i = 0; i < 100; i++) {
            randomGeneratorTest.test(new String[]{});
        }
        randomGeneratorTest.printResult();
    }

    private static void testWinnerDecision() {
        WinnerDecisionTest winnerDecisionTest = new WinnerDecisionTest();
        winnerDecisionTest.test(new String[]{"1", "Anna", "0", "Anna가 최종 우승했습니다.\n"});
        winnerDecisionTest.test(new String[]{"2", "Anna", "Ben", "1", "0", "Anna가 최종 우승했습니다.\n"});
        winnerDecisionTest.test(new String[]{"2", "Anna", "Ben", "1", "1", "Anna,Ben가 최종 우승했습니다.\n"});
        winnerDecisionTest.test(new String[]{"3", "Anna", "Ben", "Cindy", "1", "1", "1", "Anna,Ben,Cindy가 최종 우승했습니다.\n"});
        winnerDecisionTest.test(new String[]{"3", "Anna", "Ben", "Cindy", "1", "0", "1", "Anna,Cindy가 최종 우승했습니다.\n"});
        winnerDecisionTest.test(new String[]{"3", "Anna", "Ben", "Cindy", "0", "0", "1", "Cindy가 최종 우승했습니다.\n"});
        winnerDecisionTest.printResult();
    }
}
