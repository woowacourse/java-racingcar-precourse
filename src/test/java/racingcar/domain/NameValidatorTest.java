package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import racingcar.domain.validator.NameValidator;
import racingcar.domain.validator.Validator;

public class NameValidatorTest {

    private final Validator validator;

    public NameValidatorTest() {
        this.validator = new NameValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 문자열 입력 시 예외 발생")
    public void checkNullOrEmpty_NullAndEmpty_ExceptionThrown(String input) {
        assertThatThrownBy(() -> validator.validate(input))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE + Validator.INPUT_EMPTY_MESSAGE);
    }
}
