package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.domain.exception.ValidationException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidationSuccess(Validator validator, String input) {
        assertThatCode(() -> validator.validate(input)).doesNotThrowAnyException();
    }

    public static void assertValidationFailure(Validator validator, String input, String message) {
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage(ValidationException.ERROR_MESSAGE + message);
    }
}
