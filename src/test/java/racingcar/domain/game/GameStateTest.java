package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;

import static org.assertj.core.api.Assertions.assertThatCode;

class GameStateTest {

    @DisplayName("GameState 객체 정상 생성 : racingTryCounts가 1 이상일 때")
    @Test
    public void GameState_racingTryCounts가_1_이상이면_객체_생성() {
        assertThatCode(() -> {
            GameState.initiate(1);
        }).doesNotThrowAnyException();
    }

    @DisplayName("GameState 객체 생성 예외 : racingTryCounts가 1 미만일 때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void GameState_racingTryCounts가_1_미만이면_예외_발생(int racingTryCounts) {
        assertThatCode(() -> {
            GameState.initiate(racingTryCounts);
        }).isInstanceOf(RacingTryCountsNumberFormatException.class);
    }

    @DisplayName("경주 시도 횟수가 남았다면, isEnd는 false 반환")
    @Test
    public void isEnd_시도_횟수_남아있으면_false를_반환한다() {
        GameState gameState = GameState.initiate(3);

        assertThat(gameState.isEnd()).isFalse();
    }
}
