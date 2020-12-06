package racingcar.service;

import utils.RandomUtils;

public class RandomNumberGenerator {
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
