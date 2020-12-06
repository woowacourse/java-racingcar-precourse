package racingcar.domain.strategies;

import utils.RandomUtils;

public class RandomNumberStrategy implements CarMovingStrategy {
    private static final int MIN_OF_RANDOM_VALUE = 0;
    private static final int MAX_OF_RANDOM_VALUE = 9;

    @Override
    public int generate() {
        return RandomUtils.nextInt(MIN_OF_RANDOM_VALUE, MAX_OF_RANDOM_VALUE);
    }
}
