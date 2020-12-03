package racingcar;

import utils.RandomUtils;

public class MovementArbiter {
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 0;
    private static final int FORWARD_MINIMUM_CONDITION = 4;

    public static boolean canMove() {
        return RandomUtils.nextInt(MINIMUM_NUMBER, MAXIMUM_NUMBER) >= FORWARD_MINIMUM_CONDITION;
    }
}
