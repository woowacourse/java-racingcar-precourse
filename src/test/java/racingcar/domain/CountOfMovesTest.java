package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.CountOfMoves;

class CountOfMovesTest {

    @DisplayName("CountOfMoves 생성시 인자값이 0이하면 예외를 반환한다.")
    @Test
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CountOfMoves(0));
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CountOfMoves(-1));
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CountOfMoves(-999));
    }

    @DisplayName("CountOfMoves 생성시 인자값이 1이상이면 정상 생성한다.")
    @Test
    void test2() {
        assertThatNoException().isThrownBy(
                () -> new CountOfMoves(1));
    }

    @DisplayName("목표 이동횟수와 현재이동 횟수가 같으면 true를 반환한다.")
    @Test
    void test3() {
        CountOfMoves countOfMoves = new CountOfMoves(1);
        countOfMoves.increaseCurrentNumber();
        assertThat(countOfMoves.reachTargetNumber()).isTrue();
    }

    @DisplayName("목표 이동횟수와 현재이동 횟수가 다르면 false를 반환한다.")
    @Test
    void test4() {
        CountOfMoves countOfMoves = new CountOfMoves(1);
        assertThat(countOfMoves.reachTargetNumber()).isFalse();
    }
}