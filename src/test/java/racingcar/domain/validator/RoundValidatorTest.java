package racingcar.domain.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static racingcar.domain.validator.ValidatorUtils.assertValidationFailure;
import static racingcar.domain.validator.ValidatorUtils.assertValidationSuccess;

public class RoundValidatorTest {

    private RoundValidator validator;

    @BeforeEach
    public void initRoundValidator() {
        validator = new RoundValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "20"})
    @DisplayName("유효한 값 입력 시 예외 미발생")
    public void validate_ValidValue_NoExceptionThrown(String round) {
        assertValidationSuccess(validator, round);
    }

    @Test
    @DisplayName("입력 값이 숫자가 아니라면 예외 발생")
    public void checkNumeric_NotNumeric_ExceptionThrown() {
        assertValidationFailure(validator, "숫자", RoundValidator.NOT_NUMERIC_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("입력 값이 1미만이라면 예외 발생")
    public void checkNumeric_BelowOne_ExceptionThrown(String round) {
        assertValidationFailure(validator, round, RoundValidator.OUT_OF_BOUND_ROUND_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "30", "100"})
    @DisplayName("입력 값이 20 초과라면 예외 발생")
    public void checkNumeric_OverTwenty_ExceptionThrown(String round) {
        assertValidationFailure(validator, round, RoundValidator.OUT_OF_BOUND_ROUND_MESSAGE);
    }
}
