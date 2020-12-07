package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GasTankTest {

    private static final int BIG_NUMBER = 999999;

    @Test
    public void testCreate() {
        GasTank gasTank = GasTank.randomChargeGasTank();
        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(gasTank.isEnoughGas()).isTrue();
        }
    }

    @Test
    public void testFactoryMethod() {
        GasTank gasTank = GasTank.randomChargeGasTank();
        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(gasTank.isEnoughGas()).isTrue();
        }
    }

}
