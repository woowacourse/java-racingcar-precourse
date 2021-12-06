package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int MOVE_FORWARD_SCORE = 4;
    private static final int BEGIN_INDEX = 0;
    private static final int REMOVE_END_INDEX = 2;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }

    public static boolean exceedMoveForwardScoreOrNot(int score) {
        if (score >= MOVE_FORWARD_SCORE) {
            return true;
        }
        if (score < MOVE_FORWARD_SCORE) {
            return false;
        }
        return false;
    }
    public static String removeComma(String str) {
        if(str.endsWith(", ")) {
            return str.substring(BEGIN_INDEX, str.length()-REMOVE_END_INDEX);
        }
        return str;
    }
}
