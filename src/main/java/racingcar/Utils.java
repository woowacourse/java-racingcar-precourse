package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    static final int START_RANDOM_NUMBER = 0;
    static final int END_RANDOM_NUMBER = 9;
    static final int MOVE_FORWARD_SCORE = 4;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }

    public boolean getMoveForwardOrNot(int score) {
        if (score >= 4) {
            return true;
        }
        if (score < 4) {
            return false;
        }
        return false;
    }
}
