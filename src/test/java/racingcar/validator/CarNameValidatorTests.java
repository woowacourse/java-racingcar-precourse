package racingcar.validator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameValidatorTests {
    @ParameterizedTest
    @ValueSource(strings = {"myCar", "12 45", "a car"})
    public void 올바른_이름_유효성검사_통과(String name) {
        assertThatCode(() -> CarNameValidator.validate(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"myCarName", "12 456", "1 3456"})
    public void 이름의_길이가_5초과_예외발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 이름의_길이가_0이면_예외발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a\tb", "\t", "a\t\t\ta", "\t\t"})
    public void 이름에_탭을_포함하면_예외발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a  a", "a   a", "    ", "  ", "a  b "})
    public void 이름에_공백에_연속으로_나오면_예외발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(name));
    }
}
