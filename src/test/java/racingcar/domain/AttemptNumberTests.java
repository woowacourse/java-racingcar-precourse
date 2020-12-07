package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AttemptNumberTests {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "45", "100"})
    public void 올바른_숫자_유효성검사_통과(String attemptNumber) {
        assertThatCode(() -> new AttemptNumber(attemptNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "hello", "\n", "123hello", "12 34"})
    public void 숫자가_아니면_예외발생(String attemptNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new AttemptNumber(attemptNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "101"})
    public void 숫자의_범위가_벗어나면_예외발생(String attemptNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new AttemptNumber(attemptNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    public void 시도횟수_감소_성공(String number) {
        AttemptNumber attemptNumber = new AttemptNumber(number);
        int decreaseCount = Integer.parseInt(number);

        for (int i = 0; i < decreaseCount; i++) {
            attemptNumber.decrease();
        }

        assertThat(attemptNumber.isRemain())
                .isFalse();
    }
}
