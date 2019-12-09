/*
 * @(#)RacingCar.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.util.Random;

public class RacingCar extends Car implements Raceable {

    private Random randomGenerator;

    public RacingCar(String name) {
        super(name);
    }

    public RacingCar(String name, int position) {
        super(name, position);
    }

    RacingCar(String name, Random randomGenerator) {
        super(name);
        this.randomGenerator = randomGenerator;
    }

    /** race()는 RacingCar가 확률적으로 가거나 가지 않는(멈춰있는) 함수입니다. */
    @Override
    public void race() {
        if (canGo()) {
            go();
        }
    }

    private boolean canGo() {
        int randomNumber = generateRandomNumber();
        return RacingGameConfig.STANDARD_TO_GO <= randomNumber;
    }

    private int generateRandomNumber() {
        return randomGenerator.nextInt((RacingGameConfig.MAX_RANDOM_NUMBER - RacingGameConfig.MIN_RANDOM_NUMBER) + 1) + RacingGameConfig.MIN_RANDOM_NUMBER;
    }
}
