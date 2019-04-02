package com.woowa.racingcar;

import java.util.Random;

public class Car {
    private static final int RANDOM_MAX_NUMBER = 10;            /* 최대 랜덤 넘버 */
    private static final int RANDOM_THRESHOLD_NUMBER = 4;       /* move하기위한 threshold 넘버 */
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean decideMoveOrNot() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_MAX_NUMBER);

        return (randomNum >= RANDOM_THRESHOLD_NUMBER);
    }
}
