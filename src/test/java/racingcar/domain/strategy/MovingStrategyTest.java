package racingcar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovingStrategyTest {

    @DisplayName("항상 이동하는 전략은 true를 반환")
    @Test
    void isMovable_항상_이동하는_전략_true_반환한다() {
        MovingStrategy alwaysMovingStrategy = () -> true;

        boolean isMovable = alwaysMovingStrategy.isMovable();

        assertThat(isMovable).isTrue();
    }

    @DisplayName("항상 이동하지 않는 전략은 false를 반환")
    @Test
    void isMovable_항상_이동하지_않는_전략_false_반환한다() {
        MovingStrategy neverMovingStrategy = () -> false;

        boolean isMovable = neverMovingStrategy.isMovable();

        assertThat(isMovable).isFalse();
    }
}
