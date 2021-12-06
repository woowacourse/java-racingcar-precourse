package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력값 길이가 5보다 긴 이름이 있으면 예외를 던진다.")
    @Test
    void validateLengthTest() {
        InputValidator validator = new InputValidator();
        String[] inputNames = {"apple", "banana", "mango"};
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validator.validateCarNameListInput(inputNames)
        );
    }

    @DisplayName("입력값 중 중복된 이름이 있으면 예외를 던진다.")
    @Test
    void validateExistDuplicateNameTest() {
        InputValidator validator = new InputValidator();
        String[] inputNames = {"apple", "mango", "apple"};
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validator.validateCarNameListInput(inputNames)
        );
    }
}