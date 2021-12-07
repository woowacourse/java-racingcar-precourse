package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceModel {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    public static final int ADVANCE_DIVIDER = 4;

    public static boolean getRandomAdvanceResult() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER) >= ADVANCE_DIVIDER;
    }
}
