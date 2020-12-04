package racingcar.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.exception.DuplicateNameException.DUPLICATE_NAME_MESSAGE;
import static racingcar.domain.validator.ValidatorUtils.assertValidationFailure;
import static racingcar.domain.validator.ValidatorUtils.assertValidationSuccess;

import racingcar.domain.exception.DuplicateNameException;
import racingcar.domain.exception.ValidationException;

public class NameValidatorTest {

    private final Validator validator;

    public NameValidatorTest() {
        this.validator = new NameValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi, woni", "pobi,워니,준1"})
    @DisplayName("유효한 값 입력 시 예외 미발생")
    public void validate_ValidValue_NoExceptionThrown(String carNames) {
        assertValidationSuccess(validator, carNames);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 문자열 입력 시 예외 발생")
    public void checkNullOrEmpty_NullAndEmpty_ExceptionThrown(String carNames) {
        assertValidationFailure(validator, carNames, Validator.INPUT_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름이 빈 문자열 경우 예외 발생")
    public void checkNameLength_Zero_ExceptionThrown() {
        assertValidationFailure(validator, "pobi, ", NameValidator.OUT_OF_RANGE_NAME_MESSAGE +
                String.format(NameValidator.INPUT_NAME_LENGTH_MESSAGE, "", 0));
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 최대값보다 클 경우 예외 발생")
    public void checkNameLength_OverMaximumLength_ExceptionThrown() {
        String carName = "woowatechcourse";
        assertValidationFailure(validator, carName, NameValidator.OUT_OF_RANGE_NAME_MESSAGE +
                String.format(NameValidator.INPUT_NAME_LENGTH_MESSAGE, carName, carName.length()));
    }

    @Test
    @DisplayName("자동차의 대수가 최대값보다 클 경우 예외 발생")
    public void checkCarCount_OverMaximumCount_ExceptionThrown() {
        String carNames = "a,b,c,d,e,f,g,h,i";
        assertValidationFailure(validator, carNames, NameValidator.OUT_OF_BOUND_COUNT_MESSAGE +
                String.format(NameValidator.INPUT_CAR_COUNT_MESSAGE,
                        carNames.split(NameValidator.DELIMITER).length));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재할 경우 예외 발생")
    public void checkDuplicateName_DuplicateNames_ExceptionThrown() {
        assertThatThrownBy(() -> validator.validate("pobi,pobi,woni"))
                .isExactlyInstanceOf(DuplicateNameException.class)
                .hasMessage(ValidationException.ERROR_MESSAGE +
                        String.format(DUPLICATE_NAME_MESSAGE, "pobi"));
    }
}
