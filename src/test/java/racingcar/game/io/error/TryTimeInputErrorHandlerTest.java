package racingcar.game.io.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryTimeInputErrorHandlerTest {
    private final TryTimeInputErrorHandler errorHandler
        = new TryTimeInputErrorHandler();

    @DisplayName("정상 입력")
    @Test
    void validInput() {
        String[] tryTimesInput = {"1", "2", "5", "7", "10"};
        for (String tryTimes : tryTimesInput) {
             assertTrue(errorHandler.isValidInput(tryTimes));
        }
    }

    @DisplayName("숫자가 아닌 경우")
    @Test
    void notNumberError() {
        String[] tryTimesInput = {"aa", "123kl"};
        for (String tryTimes : tryTimesInput) {
            assertFalse(errorHandler.isValidInput(tryTimes));
        }
    }

    @DisplayName("시도 횟수가 1회 이상 10회 이하가 아닌 경우")
    @Test
    void notCorrectRangeError() {
        String[] tryTimesInput = {"0", "11", "100"};
        for (String tryTimes : tryTimesInput) {
            assertFalse(errorHandler.isValidInput(tryTimes));
        }
    }
}