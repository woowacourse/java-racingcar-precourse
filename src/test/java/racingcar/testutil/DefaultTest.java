/*
 * DefaultTest.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.testutil;

abstract class DefaultTest {
    int testCount;      // total number of tests
    int correctAnswer;  // number of tests got right

    DefaultTest() {
        testCount = 0;
        correctAnswer = 0;
    }

    /**
     * test will perform class-defined tests
     * and store result in testCount, correctAnswer
     */
    public abstract void test(String[] args);

    public void printResult() {
        System.out.format("%d/%d CORRECT!\n", correctAnswer, testCount);
    }

    ;
}
