package utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarMovingFlag;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarMovingFlagUtilsTest {

    @Test
    void 멈추는_플래그() {
        // given
        final int stopFlagNumberZero = 0;
        final int stopFlagNumberThree = 3;

        // when
        CarMovingFlag stopFlagByZero = CarMovingFlagUtils.selectMovingFlag(stopFlagNumberZero);
        CarMovingFlag stopFlagByThree = CarMovingFlagUtils.selectMovingFlag(stopFlagNumberThree);

        // then
        assertThat(stopFlagByZero == CarMovingFlag.STOP).isTrue();
        assertThat(stopFlagByThree == CarMovingFlag.STOP).isTrue();
    }

    @Test
    void 전진_플래그() {
        // given
        final int forwardFlagNumberFour = 4;
        final int forwardFlagNumberNine = 9;

        // when
        CarMovingFlag forwardFlagByFour = CarMovingFlagUtils.selectMovingFlag(forwardFlagNumberFour);
        CarMovingFlag forwardFlagByNine = CarMovingFlagUtils.selectMovingFlag(forwardFlagNumberNine);

        // then
        assertThat(forwardFlagByFour == CarMovingFlag.FORWARD).isTrue();
        assertThat(forwardFlagByNine == CarMovingFlag.FORWARD).isTrue();
    }

    @Test
    void 범위_외_플래그_번호() {
        // given
        final int errorFlagLessNumberMinusOne = -1;
        final int errorFlagExceedNumberTen = 10;

        // then
        assertThrows(IllegalArgumentException.class, () -> CarMovingFlagUtils.selectMovingFlag(errorFlagLessNumberMinusOne));
        assertThrows(IllegalArgumentException.class, () -> CarMovingFlagUtils.selectMovingFlag(errorFlagExceedNumberTen));
    }
}