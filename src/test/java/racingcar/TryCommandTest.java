package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.TryCommand;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCommandTest {

    private static final String EXCEPTION_MESSAGE_TRY_COMMAND_NUMBER = "[ERROR] 시도 횟수는 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_MESSAGE_TRY_COMMAND_RANGE = "[ERROR] 시도횟수는 최소 1, 최대 100000 입니다.";

    @DisplayName("TryCommand 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "100000"})
    void createTryCommandSuccess(String input) {
        boolean result = true;
        try{
            TryCommand.createTryCommandByString(input);
        }catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("숫자가 아닌 입력시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "d"})
    void createTryCommandByNotNumber(String input) {
        assertThatThrownBy(() -> TryCommand.createTryCommandByString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_TRY_COMMAND_NUMBER);
    }

    @DisplayName("값의 범위를 넘어갈시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "100001"})
    void createTryCommandByOverRange(String input) {
        assertThatThrownBy(() -> TryCommand.createTryCommandByString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_TRY_COMMAND_RANGE);
    }
}
