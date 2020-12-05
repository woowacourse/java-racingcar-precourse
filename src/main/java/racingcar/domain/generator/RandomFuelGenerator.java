package racingcar.domain.generator;

import utils.RandomUtils;

public class RandomFuelGenerator implements FuelGenerator {

    @Override
    public int generate() {
        return RandomUtils.nextInt(1, 10);
    }
}
