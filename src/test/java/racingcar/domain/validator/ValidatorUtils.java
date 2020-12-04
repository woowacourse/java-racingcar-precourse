package racingcar.domain.validator;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.domain.exception.ValidationException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidationSuccess(ThrowableAssert.ThrowingCallable callable) {
        assertThatCode(callable).doesNotThrowAnyException();
    }

    public static void assertValidationFailure(ThrowableAssert.ThrowingCallable callable,
                                               String message) {
        assertThatThrownBy(callable)
                .isInstanceOf(ValidationException.class)
                .hasMessage(ValidationException.ERROR_MESSAGE + message);
    }
}
