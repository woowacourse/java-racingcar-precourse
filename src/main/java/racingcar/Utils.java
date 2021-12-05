package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    static final int START_RANDOM_NUMBER = 0;
    static final int END_RANDOM_NUMBER = 9;

    public void getRandomNumber() {
        Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }
}
