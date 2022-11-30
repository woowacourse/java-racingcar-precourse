package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorMessageConstant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilClassCreateExceptionTest {
    @Test
    @DisplayName("예외 발생")
    void exception() {
        assertThatThrownBy(() -> {
            throw new UtilClassCreateException();
        })
                .isInstanceOf(UtilClassCreateException.class)
                .hasMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}