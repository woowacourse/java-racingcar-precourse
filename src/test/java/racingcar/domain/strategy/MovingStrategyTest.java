package racingcar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingStrategyTest {

    @DisplayName("항상 이동하는 전략은 true를 반환")
    @Test
    public void isMovable_항상_이동하는_전략_true_반환한다() {
        MovingStrategy alwaysMovingStrategy = () -> true;

        assertThat(alwaysMovingStrategy.isMovable()).isTrue();
    }

    @DisplayName("항상 이동하지 않는 전략은 false를 반환")
    @Test
    public void isMovable_항상_이동하지_않는_전략_false_반환한다() {
        MovingStrategy neverMovingStrategy = () -> false;

        assertThat(neverMovingStrategy.isMovable()).isFalse();
    }
}
