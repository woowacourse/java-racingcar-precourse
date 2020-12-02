package racingcar.domain;

import utils.RandomUtils;

public class RandomGenerator {
    private RandomGenerator() {

    }

    public static int randomGenerator() {
        int random = RandomUtils.nextInt(0, 9);
        return random;
    }
}
