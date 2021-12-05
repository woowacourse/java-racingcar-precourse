package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarGameInputHandler;

public class NameValidationTest {

    void testThrowException(String name) {
        final byte[] buf = (name + "\n").getBytes();
        Field field;
        try {
            field = Console.class.getDeclaredField("scanner");
            field.setAccessible(true);
            field.set(Scanner.class, new Scanner(new ByteArrayInputStream(buf)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThrows(
            IllegalArgumentException.class,
            CarGameInputHandler::getValidCarNames
        );
    }

    @DisplayName("정상적인 입력을 테스트한다.")
    @Test
    void checkNormalInput() {
        System.setIn(new ByteArrayInputStream("test\n".getBytes()));
        List<String> list = CarGameInputHandler.getValidCarNames();
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo("test");
    }

    @Test
    void checkLengthViolation() {
        testThrowException("123456");
    }

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
