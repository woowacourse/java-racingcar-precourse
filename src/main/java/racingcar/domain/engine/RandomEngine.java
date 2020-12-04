package racingcar.domain.engine;

import utils.RandomUtils;

public class RandomEngine implements Engine {

    private static final int MIN_HORSE_POWER = 0;
    private static final int MAX_HORSE_POWER = 9;

    @Override
    public int getDigit() {
        return RandomUtils.nextInt(MIN_HORSE_POWER, MAX_HORSE_POWER);
    }
}
