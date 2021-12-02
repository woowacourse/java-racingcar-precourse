package model.car.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarNameTest {
    private final CarName carName = new CarName("Chris");

    @Test
    @DisplayName("이름 값을 반환한다.")
    void value() {
        String actual = carName.value();
        String expected = "Chris";
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이름 값을 기준으로 동등성을 반환한다.")
    @MethodSource("provideNameAndExpected")
    void equals(final String anotherName, final boolean expected) {
        CarName anotherCarName = new CarName(anotherName);
        boolean actual = carName.equals(anotherCarName);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이름 값을 같으면 같은 해시코드를 반환한다.")
    @MethodSource("provideNameAndExpected")
    void hashCode(final String anotherName, final boolean expected) {
        CarName anotherCarName = new CarName(anotherName);
        int hashCode = carName.hashCode();
        int anotherHashCode = anotherCarName.hashCode();
        assertThat(hashCode == anotherHashCode).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNameAndExpected() {
        return Stream.of(
                Arguments.of("Chris", true),
                Arguments.of("Henry", false)
        );
    }

    @Test
    @DisplayName("이름의 길이 값이 5를 초과하면 예외를 발생시킨다.")
    void evokeExceptionByWrongLengthOfName() {
        String wrongName = "Brandon";
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(wrongName))
                .withMessage("이름은 5 글자를 초과할 수 없습니다.");
    }
}
