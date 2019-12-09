/*
 * RepetitionNumber.java
 *
 * v 0.0.0
 *
 * 2019.12.07
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

public class RepetitionNumber {
    private static final int MIN_VALUE = 1;
    private static final String SMALL_THAN_MIN_VALUE = "1이상의 값이 아닙니다.";

    private final int number;

    public RepetitionNumber(int number) {
        validateValue(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateValue(int number) {
        if (number < MIN_VALUE) {
            throw new IllegalArgumentException(SMALL_THAN_MIN_VALUE);
        }
    }
}
