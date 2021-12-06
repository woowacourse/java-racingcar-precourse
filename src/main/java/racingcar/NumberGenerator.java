package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generateRandomNumber(int minNumber, int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }
}