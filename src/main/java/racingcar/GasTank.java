package racingcar;

import utils.RandomUtils;

public class GasTank {

    private static final int MIN_GAS = 0;
    private static final int MAX_GAS = 9;
    private static final int ENOUGH_GAS = 4;

    private GasTank() {
    }

    public static GasTank randomChargeGasTank() {
        return new GasTank();
    }

    public boolean isEnoughGas() {
        return RandomUtils.nextInt(MIN_GAS, MAX_GAS) >= ENOUGH_GAS;
    }
}
