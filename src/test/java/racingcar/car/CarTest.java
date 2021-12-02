package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("이름의 길이가 5이하인 경우 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void constructor_nameLessThen5_create(String name) {
        // given & when & then
        assertThatCode(() -> {
            new Car(name);
        }).doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 5초과인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "woniii", "junnnn"})
    void constructor_nameMoreThen5_ExceptionThrown(String name) {
        // given & when & then
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}