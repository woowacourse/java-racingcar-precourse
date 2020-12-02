package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("NormalCarMoveStrategy에 대한 테스트")
class NormalCarMoveStrategyTest {

    @DisplayName("조건을 만족하면 움직일 수 있다.")
    @Test
    void isPossibleMove() {
        final int value = NormalCarMoveStrategy.MOVING_THRESHOLD + 1;

        final boolean isPossibleMove = NormalCarMoveStrategy.getInstance().isPossibleMove(value);

        assertTrue(isPossibleMove);
    }

    @DisplayName("조건을 만족하지 않으면 움직일 수 없다.")
    @Test
    void isImpossibleMove() {
        final int value = NormalCarMoveStrategy.MOVING_THRESHOLD - 1;

        final boolean isPossibleMove = NormalCarMoveStrategy.getInstance().isPossibleMove(value);

        assertFalse(isPossibleMove);
    }
}