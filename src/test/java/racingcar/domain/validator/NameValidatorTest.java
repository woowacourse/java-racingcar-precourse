package racingcar.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameValidatorTest {

    private final Validator validator;

    public NameValidatorTest() {
        this.validator = new NameValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi, woni", "pobi,워니,준1"})
    @DisplayName("유효한 값 입력 시 예외 미발생")
    public void validate_ValidValue_NoExceptionThrown(String carNames) {
        ValidatorUtils.assertValidationSuccess(validator, carNames);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 문자열 입력 시 예외 발생")
    public void checkNullOrEmpty_NullAndEmpty_ExceptionThrown(String carNames) {
        ValidatorUtils.assertValidationFailure(validator, carNames, Validator.INPUT_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름이 빈 문자열 경우 예외 발생")
    public void checkNameLength_Zero_ExceptionThrown() {
        ValidatorUtils.assertValidationFailure(validator, "pobi, ",
                NameValidator.OUT_OF_RANGE_NAME_MESSAGE +
                        String.format(NameValidator.INPUT_NAME_LENGTH_MESSAGE, "", 0));
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5 초과일 경우 예외 발생")
    public void checkNameLength_Six_ExceptionThrown() {
        String carName = "woowatechcourse";
        ValidatorUtils.assertValidationFailure(validator, carName,
                NameValidator.OUT_OF_RANGE_NAME_MESSAGE +
                        String.format(NameValidator.INPUT_NAME_LENGTH_MESSAGE, carName, carName.length()));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재할 경우 예외 발생")
    public void checkDuplicateName_DuplicateNames_ExceptionThrown() {
        ValidatorUtils.assertValidationFailure(validator, "pobi,pobi,woni",
                NameValidator.DUPLICATE_NAME_MESSAGE);
    }
}
