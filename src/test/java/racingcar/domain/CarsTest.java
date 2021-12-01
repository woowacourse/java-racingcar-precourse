package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("names가 빈값, 5자리를 넘을경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void illegalCarsName(String name) {
        assertThatThrownBy(() -> Cars.createByNames(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("names가 null일 경우 예외발생 테스트")
    @Test
    void nullNameTest() {
        assertThatThrownBy(() -> Cars.createByNames(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 names 일 경우 테스트 패스")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void validName(String name) {
       Cars.createByNames(name);
    }
}
