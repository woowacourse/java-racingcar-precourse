package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Constraint.*;

public class RandomNumberGenerator {
    private static int randomNumber;

    public static int getRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);

        return randomNumber;
    }
}
