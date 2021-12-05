package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"t1", "1 2", "-4"})
    @DisplayName("생성 시도횟수가 숫자가 아닌 경우 exception이 발생해야 한다.")
    void createExceptionByStringRoundTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Round.createByStringRound(input))
            .withMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("생성 시도횟수가 0인 경우 exception이 발생해야 한다.")
    void createExceptionByZeroRoundTest() {
        // given
        String input = "0";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Round.createByStringRound(input))
            .withMessage("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도횟수가 0이하인데 decreaseRound한 경우 exception이 발생해야 한다.")
    void raceExceptionByZeroRoundTest() {
        // given
        Round round = Round.createByStringRound("1");
        round.decreaseRound();

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> round.decreaseRound())
            .withMessage("[ERROR] 시도횟수가 남지 않았을 때는 race 할 수 없습니다.");
    }

    @Test
    @DisplayName("현재 round가 0인지 확인할 수 있다.")
    void isFinishedTest() {
        // given
        Round round = Round.createByStringRound("1");
        round.decreaseRound();

        // when
        boolean result = round.isFinished();

        // then
        assertTrue(result);
    }
}