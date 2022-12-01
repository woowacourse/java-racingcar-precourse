package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputTryNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "a1", "a", "AA", "-1"})
    void 입력한_시도_횟수가_1_이상의_숫자가_아니면_예외_발생(String inputTryNumber) {
        InputTryNumberValidator inputTryNumberValidator = new InputTryNumberValidator();

        Assertions.assertThatThrownBy(() -> inputTryNumberValidator.validate(inputTryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 1이상의 숫자여야합니다.");
    }
}