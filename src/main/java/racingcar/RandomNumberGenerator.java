package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static int randomNumber;

    public static int getRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(1, 9);

        return randomNumber;
    }
}
