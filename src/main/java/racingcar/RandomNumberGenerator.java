package racingcar;

import utils.RandomUtils;

public class RandomNumberGenerator {
    private static final int MINIMUM_LIMIT = 0;
    private static final int MAXIMUM_LIMIT = 9;

    public static int generateRandomNumber(){
        return RandomUtils.nextInt(MINIMUM_LIMIT,MAXIMUM_LIMIT);
    }

}
