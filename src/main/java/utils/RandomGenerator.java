package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 9;

    public static int create() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}