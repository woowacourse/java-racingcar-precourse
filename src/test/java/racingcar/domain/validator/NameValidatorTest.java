package racingcar.domain.validator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static racingcar.domain.validator.ValidatorUtils.assertValidationFailure;
import static racingcar.domain.validator.ValidatorUtils.assertValidationSuccess;

import racingcar.domain.exception.CarCountOutOfBoundsException;
import racingcar.domain.exception.DuplicateNameException;
import racingcar.domain.exception.NameLengthOutOfBoundsException;
import racingcar.view.InputView;

public class NameValidatorTest {

    private final Validator validator = new NameValidator();

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi, woni", "pobi,워니,준1"})
    @DisplayName("유효한 값 입력 시 예외 미발생")
    public void validate_ValidValue_NoExceptionThrown(String carNames) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationSuccess(callable);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 문자열 입력 시 예외 발생")
    public void checkNullOrEmpty_NullAndEmpty_ExceptionThrown(String carNames) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationFailure(callable, Validator.INPUT_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름이 빈 문자열 경우 예외 발생")
    public void checkNameLength_Zero_ExceptionThrown() {

        // given
        String carNames = "pobi, ";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationFailure(callable, NameLengthOutOfBoundsException.OUT_OF_BOUNDS_MESSAGE +
                String.format(NameLengthOutOfBoundsException.INPUT_NAME_MESSAGE, "", 0));
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 최대값보다 클 경우 예외 발생")
    public void checkNameLength_OverMaximumLength_ExceptionThrown() {

        // given
        String carNames = "woowatechcourse";
        int length = carNames.length();

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationFailure(callable, NameLengthOutOfBoundsException.OUT_OF_BOUNDS_MESSAGE +
                String.format(NameLengthOutOfBoundsException.INPUT_NAME_MESSAGE, carNames, length));
    }

    @Test
    @DisplayName("자동차의 대수가 최대값보다 클 경우 예외 발생")
    public void checkCarCount_OverMaximumCount_ExceptionThrown() {

        // given
        String carNames = "a,b,c,d,e,f,g,h,i";
        int length = carNames.split(InputView.DELIMITER).length;

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationFailure(callable, CarCountOutOfBoundsException.OUT_OF_BOUNDS_MESSAGE +
                String.format(CarCountOutOfBoundsException.INPUT_CAR_COUNT_MESSAGE, length));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재할 경우 예외 발생")
    public void checkDuplicateName_DuplicateNames_ExceptionThrown() {

        // given
        String carNames = "pobi,pobi,woni";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(carNames);

        // then
        assertValidationFailure(callable,
                String.format(DuplicateNameException.DUPLICATE_NAME_MESSAGE, "pobi"));
    }
}
