package racingcar.domain.generator;

import utils.RandomUtils;

public final class RandomFuelGenerator implements FuelGenerator {

    public static final int LOWER_BOUND = 0;

    public static final int UPPER_BOUND = 10;

    @Override
    public int generate() {
        return RandomUtils.nextInt(LOWER_BOUND, UPPER_BOUND);
    }
}
