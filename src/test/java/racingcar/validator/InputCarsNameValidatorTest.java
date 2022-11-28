package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatNoException;

class InputCarsNameValidatorTest {
    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun", "jun,pobi", "j", "jun,pobi,crong"}, delimiter = ':')
    void normalInput(final String carsName) {
        assertThatNoException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName));
    }
}