package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatNoException;

class InputNumberOfTryValidatorTest {
    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name = "{displayName} : numberOfTry => {0}")
    @CsvSource(value = {"1", "9", "19", "20"})
    void normalInput(final String numberOfTry) {
        assertThatNoException()
                .isThrownBy(() -> InputNumberOfTryValidator.validate(numberOfTry));
    }
}