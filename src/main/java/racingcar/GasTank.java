package racingcar;

import utils.RandomUtils;

public class GasTank {

    private static final int MIN_GAS = 0;
    private static final int MAX_GAS = 9;
    private static final int ENOUGH_GAS = 4;

    public boolean getChargeGas() {
        if(RandomUtils.nextInt(MIN_GAS, MAX_GAS) < ENOUGH_GAS){
            return false;
        }
        return true;
    }
}
