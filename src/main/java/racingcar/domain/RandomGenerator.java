package racingcar.domain;

import utils.RandomUtils;

public class RandomGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private RandomGenerator() {

    }

    public static int randomGenerator() {
        int random = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        return random;
    }
}
