package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorMessageConstant;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputNumberOfTryValidatorTest {
    @DisplayName("이동 횟수 정상 입력")
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
    
    @DisplayName("예외 처리 : 첫번째 자리에 0이 오는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"014000", "0014000", "00014000", "01", "001", "045", "0045", "00045"})
    void zeroAtFirstPlaceExistException(String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberOfTryValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"14 000", " 14000", "14000 "})
    void spaceInputException(String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberOfTryValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}