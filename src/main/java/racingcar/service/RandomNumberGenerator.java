package racingcar.service;

import utils.RandomUtils;

import static racingcar.constant.Constants.MAX_RANDOM_VALUE;
import static racingcar.constant.Constants.MIN_RANDOM_VALUE;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
