package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private static final int CONDITION_VALUE = 4;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private RandomUtil() {
    }

    public static boolean checkMoveOrWait() {
        int randomNumber = getRandomNumber();

        if (randomNumber >= CONDITION_VALUE) {
            return true;
        }

        return false;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
