package utils.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveInputValidatorTest {

    @Test
    void 음수입력_테스트() {
        // given, when
        String numOfMove = "-1";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            MoveInputValidator.validateNumOfMove(numOfMove);
        });
    }

    @Test
    void 숫자가_아닌_입력_테스트() {
        // given, when
        String numOfMove = "pobi";

        // then
        assertThrows(NumberFormatException.class, () -> {
            MoveInputValidator.validateNumOfMove(numOfMove);
        });
    }

}