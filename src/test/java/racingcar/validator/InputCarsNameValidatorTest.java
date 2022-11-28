package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.constants.ErrorMessageConstant;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputCarsNameValidatorTest {
    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun", "jun,pobi", "j", "jun,pobi,crong"}, delimiter = ':')
    void normalInput(final String carsName) {
        assertThatNoException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName));
    }
    
    @DisplayName("예외 처리 : null or empty 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @NullAndEmptySource
    void nullOrEmptyInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}