package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
