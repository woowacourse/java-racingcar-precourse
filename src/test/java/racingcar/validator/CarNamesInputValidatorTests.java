package racingcar.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNamesInputValidatorTests {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "name"})
    public void 올바른_입력_유효성검사_통과(String carNamesInput) {
        assertThatCode(() -> CarNamesInputValidator.validate(carNamesInput))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni,jun", "pobi,,,", ",,,pobi,woni"})
    public void 입력에_쉼표가_연속으로_포함되면_예외발생(String carNamesInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNamesInputValidator.validate(carNamesInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi", "pobi,woni,", ",", ",pobi,woni,"})
    public void 입력의_시작이나_끝이_쉼표이면_예외발생(String carNamesInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNamesInputValidator.validate(carNamesInput));
    }
}
