package racingcar.domain.trycount;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.error.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("문자열 시도 횟수가 숫자이고 음수가 아니면 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void constructor_InputTryCountThenNumberFormatAndNotNegativeNumber_Success(String inputTryCount) {
        // given & when & then
        assertThatCode(() -> {
            new TryCount(inputTryCount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("문자열 시도 횟수가 숫자가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"1a", "ab", "3a0", "4O", "s5"})
    void constructor_InputTryCountThenNotNumberFormat_ExceptionThrown(String inputTryCount) {
        // given & when & then
        assertThatThrownBy(() -> {
            new TryCount(inputTryCount);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NUMBER_FORMAT_NOT_VALID.getMessage());
    }

    @DisplayName("문자열 시도 횟수가 음수이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5"})
    void constructor_InputTryCountThenNegativeNumber_ExceptionThrown(String inputTryCount) {
        // given & when & then
        assertThatThrownBy(() -> {
            new TryCount(inputTryCount);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NEGATIVE_NUMBER_NOT_VALID.getMessage());
    }
}