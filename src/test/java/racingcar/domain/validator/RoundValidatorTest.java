package racingcar.domain.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static racingcar.domain.validator.ValidatorUtils.assertValidationFailure;
import static racingcar.domain.validator.ValidatorUtils.assertValidationSuccess;

import racingcar.domain.exception.NotNumericException;
import racingcar.domain.exception.RoundOutOfBoundsException;

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

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(round);

        // then
        assertValidationSuccess(callable);
    }

    @Test
    @DisplayName("입력 값이 숫자가 아니라면 예외 발생")
    public void checkNumeric_NotNumeric_ExceptionThrown() {

        // given
        String round = "숫자";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(round);

        // then
        assertValidationFailure(callable,
                String.format(NotNumericException.NOT_NUMERIC_MESSAGE, round));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("입력 값이 최소값보다 작다면 예외 발생")
    public void checkNumeric_BelowMinimum_ExceptionThrown(String round) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(round);

        // then
        assertValidationFailure(callable,
                String.format(RoundOutOfBoundsException.OUT_OF_RANGE_ROUND_MESSAGE,
                        RoundValidator.MINIMUM_ROUND, RoundValidator.MAXIMUM_ROUND, round));
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "30", "100"})
    @DisplayName("입력 값이 최대값보다 크다면 예외 발생")
    public void checkNumeric_OverMaximum_ExceptionThrown(String round) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(round);

        // then
        assertValidationFailure(callable,
                String.format(RoundOutOfBoundsException.OUT_OF_RANGE_ROUND_MESSAGE,
                        RoundValidator.MINIMUM_ROUND, RoundValidator.MAXIMUM_ROUND, round));
    }
}
