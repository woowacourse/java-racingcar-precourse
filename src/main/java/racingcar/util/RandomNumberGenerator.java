package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Constraint.*;

public class RandomNumberGenerator {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
    }
}
