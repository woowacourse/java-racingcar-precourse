package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TokenTest {
    @DisplayName("토큰 생성시 유효하지 않은 값에 대한 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "!", "%"})
    void tokenFromInvalidValue(String value) {
        assertThatThrownBy(() -> Token.from(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("토큰 생성시 null값에 대한 예외발생")
    @Test
    void tokenFromNull() {
        assertThatThrownBy(() -> Token.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("토큰 생성시 유효한 값에 대한 통과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234"})
    void tokenFromValidValue(String value) {
        Token.from(value);
    }
}
