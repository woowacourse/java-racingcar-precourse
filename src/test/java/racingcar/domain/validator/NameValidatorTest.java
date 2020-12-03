package racingcar.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.domain.CustomIllegalArgumentException;

public class NameValidatorTest {

    private final Validator validator;

    public NameValidatorTest() {
        this.validator = new NameValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi, woni", "pobi,워니,준1"})
    @DisplayName("유효한 값 입력 시 예외 미발생")
    public void validate_ValidValue_NoExceptionThrown(String carNames) {
        assertThatCode(() -> validator.validate(carNames)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 문자열 입력 시 예외 발생")
    public void checkNullOrEmpty_NullAndEmpty_ExceptionThrown(String carNames) {
        assertThatThrownBy(() -> validator.validate(carNames))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE +
                        Validator.INPUT_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름이 빈 문자열 경우 예외 발생")
    public void checkNameLength_Zero_ExceptionThrown() {
        String carNames = "pobi,";
        assertThatThrownBy(() -> validator.validate(carNames))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE +
                        NameValidator.OUT_OF_BOUND_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5 초과일 경우 예외 발생")
    public void checkNameLength_Six_ExceptionThrown() {
        String carNames = "woowatechcourse";
        assertThatThrownBy(() -> validator.validate(carNames))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE +
                        NameValidator.OUT_OF_BOUND_MESSAGE);
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재할 경우 예외 발생")
    public void checkDuplicateName_DuplicateNames_ExceptionThrown() {
        String carNames = "pobi,pobi,woni";
        assertThatThrownBy(() -> validator.validate(carNames))
                .isExactlyInstanceOf(CustomIllegalArgumentException.class)
                .hasMessage(CustomIllegalArgumentException.ERROR_MESSAGE +
                        NameValidator.DUPLICATE_NAME_MESSAGE);
    }
}
