package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("Cars 생성 시 빈값, 5자리를 넘는 입력값에 대한 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456", "123456789"})
    void carsFromInvalidValue(String name) {
        assertThatThrownBy(() -> Cars.createByNames(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Cars 생성 시 입력값이 null일 경우 예외발생 테스트")
    @Test
    void carsFromNull() {
        assertThatThrownBy(() -> Cars.createByNames(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Cars 생성 시 유효한 입력값인 경우 통과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345", "12345,1", "12345,12345"})
    void carsFromValidValue(String name) {
       Cars.createByNames(name);
    }
}
