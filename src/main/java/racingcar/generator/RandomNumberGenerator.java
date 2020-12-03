package racingcar.generator;

import utils.RandomUtils;

public class RandomNumberGenerator {
    private static final int MAX_LIMIT = 9;
    private static final int MIN_LIMIT = 1;

    public static int generateRandomNumber(){
        return RandomUtils.nextInt(MAX_LIMIT, MIN_LIMIT);
    }
}
