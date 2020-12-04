package racingcar.domain.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.domain.CustomIllegalArgumentException;

public class RoundValidatorTest {

    private RoundValidator validator;

    @BeforeEach
    public void initRoundValidator() {
        validator = new RoundValidator();
    }

    @Test
    @DisplayName("입력 값이 숫자가 아니라면 예외 발생")
    public void checkNumeric_NotNumeric_ExceptionThrown() {
        String round = "숫자";
        assertThatThrownBy(() -> validator.validate(round))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE +
                        RoundValidator.NOT_NUMERIC_MESSAGE);
    }
}
