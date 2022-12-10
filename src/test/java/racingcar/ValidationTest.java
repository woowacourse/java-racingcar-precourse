package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Util.Validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Message.Error.*;

public class ValidationTest {

    private final Validation validate = new Validation();

    @Test
    @DisplayName("차량 중복 입력시 예외확인")
    void duplicationOfNames() {
        String input = "A,A,B,C";

        assertThatThrownBy(() -> validate.validInputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NAMES.toString("A"));
    }

    @Test
    @DisplayName("차량이름의 길이초과 예외확인")
    void outOfNameLength() {
        String input = "A123,A1234,BBB123,C";

        assertThatThrownBy(() -> validate.validInputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_PROPER_NAME_LENGTH.toString());
    }

    @Test
    @DisplayName("차량이름의 길이미달 예외확인")
    void notExistName() {
        String input = "A123,,BBB123,C";

        assertThatThrownBy(() -> validate.validInputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_PROPER_NAME_LENGTH.toString());
    }

    @Test
    @DisplayName("공백문자 예외확인")
    void blankExist(){
        String input = "AAA,BBB,CCC,D D";

        assertThatThrownBy(() -> validate.validInputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_BLANK_OF_NAME.toString());
    }

    @Test
    @DisplayName("횟수를 문자로 입력시 예외확인")
    void notNumberValue(){
        String input = "열번";

        assertThatThrownBy(() -> validate.validTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_INPUT_COUNT.toString());
    }

    @Test
    @DisplayName("횟수를 0이하 입력시 예외확인")
    void countZero(){
        String input = "-1";

        assertThatThrownBy(() -> validate.validTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_ALLOWED_UNDER_ZERO.toString());
    }

}
