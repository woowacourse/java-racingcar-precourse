package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {
    }

    public static boolean checkMoveOrWait() {
        int randomNumber = getRandomNumber();

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
