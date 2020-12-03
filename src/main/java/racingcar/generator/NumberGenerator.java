package racingcar.generator;

import utils.RandomUtils;

/** 0~9 사이에서 random 값을 구하는 클래스 */
public class NumberGenerator {

    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    public static int generateNumber() {
        int randomNumber = RandomUtils.nextInt(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);

        return randomNumber;
    }
}
