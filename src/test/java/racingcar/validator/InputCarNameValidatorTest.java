package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputCarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "aaa, bbb", "aaa,bbbbbbbb", "aa.bb"})
    void 자동차_이름_형식이_틀린_경우_예외_발생(String inputCarName) {
        InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();

        Assertions.assertThatThrownBy(() -> inputCarNameValidator.validate(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하이고, 쉼표로 구분된 문자여야합니다.");
    }
}