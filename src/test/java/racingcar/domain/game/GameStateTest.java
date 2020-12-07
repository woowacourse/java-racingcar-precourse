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
    void GameState_유효한_racingTryCounts_객체_생성_성공() {
        assertThatCode(() -> {
            GameState.initiate(1);
        }).doesNotThrowAnyException();
    }

    @DisplayName("GameState 객체 생성 예외 : racingTryCounts가 1 미만일 때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void GameState_유효하지_않은_racingTryCounts_예외가_발생한다(int racingTryCounts) {
        assertThatCode(() -> {
            GameState.initiate(racingTryCounts);
        }).isInstanceOf(RacingTryCountsNumberFormatException.class)
                .hasMessage("[ERROR] 시도 횟수는 1 이상의 숫자만 가능합니다.");
    }

    @DisplayName("isEnd false 반환 : 경주 시도 횟수가 남은 경우")
    @Test
    void isEnd_시도_횟수_남아있으면_false를_반환한다() {
        GameState gameState = GameState.initiate(3);

        boolean isEnd = gameState.isEnd();

        assertThat(isEnd).isFalse();
    }

    @DisplayName("경주 시도 횟수 차감을 요청하면, 경주 시도 횟수가 1만큼 줄어든다")
    @Test
    void decreaseRacingTryCounts_경주_시도_횟수가_1만큼_줄어든다() {
        GameState gameState = GameState.initiate(1);
        gameState.decreaseRacingTryCounts();

        boolean isEnd = gameState.isEnd();

        assertThat(isEnd).isTrue();
    }

    @DisplayName("잔여 시도 횟수가 없을 때, 경주 시도 횟수 차감을 요청하면 예외 발생")
    @Test
    void decreaseRacingTryCounts_남은_경주_시도_횟수가_없으면_예외가_발생한다() {
        GameState gameState = GameState.initiate(1);
        gameState.decreaseRacingTryCounts();

        assertThatCode(gameState::decreaseRacingTryCounts)
                .isInstanceOf(CannotRaceException.class)
                .hasMessage("[ERROR] 시도 횟수를 초과했기 때문에 경주를 진행할 수 없습니다.");
    }
}
