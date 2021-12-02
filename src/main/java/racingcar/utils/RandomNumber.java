package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int PASS_VALUE = 4;

    public static boolean checkPassOrFail() {
        return generateRandomNumber(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE) >= PASS_VALUE;
    }

    private static int generateRandomNumber(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
