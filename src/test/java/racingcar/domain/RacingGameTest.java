package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private List<String> names;

    @BeforeEach
    void beforeEach() {
        names = Arrays.asList("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"t1", "1 2", "-4"})
    @DisplayName("시도횟수가 숫자가 아닌 경우 exception이 발생해야 한다.")
    void createExceptionByStringRoundTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingGame.createRandomCarRacing(names, input))
            .withMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("시도횟수가 0인 경우 exception이 발생해야 한다.")
    void createExceptionByZeroRoundTest() {
        // given
        String input = "0";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingGame.createRandomCarRacing(names, input))
            .withMessage("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도횟수가 0이하인데 race한 경우 exception이 발생해야 한다.")
    void raceExceptionByZeroRoundTest() {
        // given
        RacingGame racingGame = RacingGame.createRandomCarRacing(names, "1");
        racingGame.race();

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> racingGame.race())
            .withMessage("[ERROR] 시도횟수가 남지 않았을 때는 race 할 수 없습니다.");
    }
}