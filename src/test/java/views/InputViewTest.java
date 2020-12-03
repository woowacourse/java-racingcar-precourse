package views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private static final String EMPTY_INPUT = "";
    private static final String NOT_NUMBER = "12a";
    private static final String ZERO = "0";
    private static final String EMPTY_EXCEPTION = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String NOT_NUMBER_EXCEPTION = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String IMPOSSIBLE_NUMBER_ZERO_EXCEPTION = "[ERROR] 0은 임력할 수 없습니다.";

    InputView inputView = new InputView();

    @Test
    void isEmptyTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.isEmptyValue(EMPTY_INPUT);
        });
        Assertions.assertEquals(EMPTY_EXCEPTION, exception.getMessage());
    }

    @Test
    void stringToIntTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.isNumber(NOT_NUMBER);
        });
        Assertions.assertEquals(NOT_NUMBER_EXCEPTION, exception.getMessage());
    }

    @Test
    void isZeroTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.isZero(ZERO);
        });
        Assertions.assertEquals(IMPOSSIBLE_NUMBER_ZERO_EXCEPTION, exception.getMessage());
    }
}