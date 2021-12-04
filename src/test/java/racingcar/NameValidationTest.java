package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarGameInputHandler;

public class NameValidationTest {

    void isValidName(String name) {
        final byte[] input = name.getBytes();
        System.setIn(new ByteArrayInputStream(input));
        assertThrows(
            IllegalArgumentException.class,
            CarGameInputHandler::getCarNames
        );
    }

    @Test
    void checkLengthViolation() {
        isValidName("12345");
    }

    @Test
    void checkEmptyViolation() {
        isValidName("");
    }

    @DisplayName("이름의 형식조건 위반을 테스트한다.")
    @Test
    void checkMultipleNamesFormatViolation() {
        String[] cases = new String[] {
            ",name",
            ",,name",
            "name,",
            "name,,",
            "name,,name1"
        };
        for (String name: cases) {
            isValidName(name);
        }
    }
}
