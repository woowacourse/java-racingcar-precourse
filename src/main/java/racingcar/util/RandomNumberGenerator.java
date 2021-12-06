package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int MIN_NUMBER_VALUE = 0;
    public static final int MAX_NUMBER_VALUE = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
    }
}
