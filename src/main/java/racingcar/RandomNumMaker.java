package racingcar;

import utils.RandomUtils;

public class RandomNumMaker {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    public static int run() {
        return RandomUtils.nextInt(MIN_BOUND, MAX_BOUND);
    }
}
