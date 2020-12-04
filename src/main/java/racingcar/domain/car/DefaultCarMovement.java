package racingcar.domain.car;

import utils.RandomUtils;

public class DefaultCarMovement implements CarMovement {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int STEP_FORWARD_REFERENCE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= STEP_FORWARD_REFERENCE_NUMBER;
    }
}
