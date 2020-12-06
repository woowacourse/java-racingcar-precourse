package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.CannotRaceException;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("경주 시도 횟수 차감을 요청하면, 경주 시도 횟수가 1만큼 줄어든다")
    @Test
    public void decreaseRacingTryCounts_경주_시도_횟수가_1만큼_줄어든다() {
        GameState gameState = GameState.initiate(1);

        gameState.decreaseRacingTryCounts();

        assertThat(gameState.isEnd()).isTrue();
    }

    @DisplayName("잔여 시도 횟수가 없을 때, 경주 시도 횟수 차감을 요청하면 예외 발생")
    @Test
    public void decreaseRacingTryCounts_예외_발생() {
        GameState gameState = GameState.initiate(1);
        gameState.decreaseRacingTryCounts();

        assertThatCode(() -> {
            gameState.decreaseRacingTryCounts();
        }).isInstanceOf(CannotRaceException.class);
    }
}
