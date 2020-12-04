package racingcar;

import utils.RandomUtils;

public class GasTank {

    private static final int MIN_GAS = 0;
    private static final int MAX_GAS = 9;

    public int getChargeGas() {
        return RandomUtils.nextInt(MIN_GAS, MAX_GAS);
    }
}
