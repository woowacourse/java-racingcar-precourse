package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTests {
    private static Stream<Arguments> correctArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList("sp ce", "a", "b"))
        );
    }

    private static Stream<Arguments> wrongArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("longname", "ok", "name")),
                Arguments.of(Arrays.asList("", "ok", "name")),
                Arguments.of(Arrays.asList("dupli", "dupli", "name")),
                Arguments.of(Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("correctArguments")
    public void 객체생성_성공(List<String> names) {
        assertThatCode(() -> Cars.generate(names))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("wrongArguments")
    public void 객체생성_실패_예외발생(List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.generate(names));
    }
}

