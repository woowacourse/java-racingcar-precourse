package utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarMovingFlag;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void 모두_STOP_플래그_리스트_검증() {
        // given
        final int stopFlagNumber = 1;
        final int lenOfList = 3;
        List<Integer> onlyStopFlagNumberList = new ArrayList<>(lenOfList);
        List<CarMovingFlag> expectedFlagList = new ArrayList<>(lenOfList);

        // when
        for (int index = 0; index < lenOfList; index++) {
            onlyStopFlagNumberList.add(stopFlagNumber);
            expectedFlagList.add(CarMovingFlag.STOP);
        }

        // then
        assertThat(CarMovingFlagUtils.makeCarMovieFlagList(onlyStopFlagNumberList)).isEqualTo(expectedFlagList);
    }

    @Test
    void flag_1_STOP_1_FORWARD_플래그_리스트_검증() {
        // given
        final int stopFlagNumber = 1;
        final int forwardFlagNumber = 5;
        final int lenOfList = 2;
        List<Integer> oneStopOneForwardFlagNumberList = new ArrayList<>(lenOfList);
        List<CarMovingFlag> expectedFlagList = new ArrayList<>(lenOfList);

        // when
        oneStopOneForwardFlagNumberList.add(stopFlagNumber);
        expectedFlagList.add(CarMovingFlag.STOP);
        oneStopOneForwardFlagNumberList.add(forwardFlagNumber);
        expectedFlagList.add(CarMovingFlag.FORWARD);

        // then
        assertThat(CarMovingFlagUtils.makeCarMovieFlagList(oneStopOneForwardFlagNumberList)).isEqualTo(expectedFlagList);
    }

    @Test
    void 모두_FORWARD_플래그_리스트_검증() {
        // given
        final int forwardFlagNumber = 5;
        final int lenOfList = 3;
        List<Integer> onlyForwardFlagNumberList = new ArrayList<>(lenOfList);
        List<CarMovingFlag> expectedFlagList = new ArrayList<>(lenOfList);

        // when
        for (int index = 0; index < lenOfList; index++) {
            onlyForwardFlagNumberList.add(forwardFlagNumber);
            expectedFlagList.add(CarMovingFlag.FORWARD);
        }

        // then
        assertThat(CarMovingFlagUtils.makeCarMovieFlagList(onlyForwardFlagNumberList)).isEqualTo(expectedFlagList);
    }
}