package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.InputValidator;

public class NameValidationTest {

    void testThrowException(String name) {
        assertThrows(
            IllegalArgumentException.class,
            () -> InputValidator.validateCarNames(name)
        );
    }

    @DisplayName("정상적인 입력을 테스트한다.")
    @Test
    void checkNormalInput() {
        String name = "test";
        assertDoesNotThrow(() -> InputValidator.validateCarNames(name));
    }

    @DisplayName("이름 길이를 검증한다.")
    @Test
    void checkLengthViolation() {
        testThrowException("123456");
    }

    @DisplayName("빈 이름을 검증한다.")
    @Test
    void checkEmptyViolation() {
        testThrowException("");
    }

    @DisplayName("이름의 형식조건 위반을 테스트한다.")
    @Test
    void checkMultipleNamesFormatViolation() {
        String[] cases = new String[]{
            ",,name",
            "name,",
            "name,,",
            "name,,name1"
        };
        for (String name : cases) {
            testThrowException(name);
        }
    }

    @DisplayName("이름 중복 검증을 테스트한다.")
    @Test
    void checkDuplicatedNamesViolation() {
        testThrowException("name,name,name2");
    }

}
