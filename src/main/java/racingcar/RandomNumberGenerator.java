package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int START_INCLUSIVE_NUMBER = 0;
    private static final int END_INCLUSIVE_NUMBER = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
    }
}
