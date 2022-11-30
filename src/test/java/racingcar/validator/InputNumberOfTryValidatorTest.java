package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.constants.ErrorMessageConstant;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputNumberOfTryValidatorTest {
    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name = "{displayName} : numberOfTry => {0}")
    @CsvSource(value = {"1", "9", "19", "20"})
    void normalInput(final String numberOfTry) {
        assertThatNoException()
                .isThrownBy(() -> InputNumberOfTryValidator.validate(numberOfTry));
    }
    
    @DisplayName("예외 처리 : null or empty 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @NullAndEmptySource
    void nullOrEmptyInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberOfTryValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}