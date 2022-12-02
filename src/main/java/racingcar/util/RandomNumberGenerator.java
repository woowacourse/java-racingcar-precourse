package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    public static int generate() {
        return pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
