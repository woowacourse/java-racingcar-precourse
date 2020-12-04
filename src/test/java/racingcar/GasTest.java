package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GasTest {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int BIG_NUMBER = 999999;

    @Test
    public void testCreate() {
        Gas gas = new Gas();
        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(gas.getChargeGas()).isBetween(MIN_VALUE, MAX_VALUE);
        }
    }

}
