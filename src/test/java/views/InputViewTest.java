package views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private static final String EMPTY_INPUT = "";
    private static final String EXPECTED_EXCEPTION_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";

    @Test
    void inputTest() {
        InputView inputView = new InputView();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.isValidCarNames(EMPTY_INPUT);
        });
        Assertions.assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
    }
}