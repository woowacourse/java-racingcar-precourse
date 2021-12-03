package racingcar.utils;

import static org.assertj.core.api.Assertions.*;
import static racingcar.utils.ValidationUtil.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilTest {

    @DisplayName("null값 예외발생 테스트")
    @Test
    void checkNull() {
        assertThatThrownBy(() -> {
            ValidationUtil.checkNull(null);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_EMPTY_MENTION);
    }

    @DisplayName("빈값 예외발생 테스트")
    @Test
    void checkEmpty() {
        assertThatThrownBy(() -> {
            ValidationUtil.checkEmpty("");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_EMPTY_MENTION);
    }

    @DisplayName("6자리 이상의 값 예외발생 테스트")
    @Test
    void checkInvalidLength() {
        assertThatThrownBy(() -> {
            ValidationUtil.checkLength("123456");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_OVER_LENGTH_MENTION);
    }

    @DisplayName("1자리 이상 5자리 이하의 값 통과 테스트")
    @Test
    void checkValidLength() {
        ValidationUtil.checkLength("1");
        ValidationUtil.checkLength("12345");
    }

    @DisplayName("공백을 제외한 첫자리가 쉼표일 경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",", " , ", " , 12345"})
    void checkCommaInFirst(String value) {
        assertThatThrownBy(() -> {
            ValidationUtil.checkCommaInFirst(value);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_START_COMMA_MENTION);
    }

    @DisplayName("쉼표를 기준으로 나눈값 중 중복문자가 있을경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,1", "1,2,1", "123, 123"})
    void checkDuplicate(String value) {
        assertThatThrownBy(() -> {
            ValidationUtil.checkDuplicate(value);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_DUPLICATE_MENTION);
    }

    @DisplayName("구분자 없는 입력값의 경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void checkNameCount(String value) {
        assertThatThrownBy(() -> {
            ValidationUtil.checkNameCount(value);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_NAME_COUNT_MENTION);
    }
}
