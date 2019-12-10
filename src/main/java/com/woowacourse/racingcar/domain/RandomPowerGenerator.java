package com.woowacourse.racingcar.domain;

import java.util.Random;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class RandomPowerGenerator {
    private final Random random;

    public RandomPowerGenerator(Random random) {
        this.random = random;
    }

    public int getPower() {
        return random.nextInt(Car.MAX_POWER + 1);
    }
}
