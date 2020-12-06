package racingcar;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CarNameValidatorTest {
    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름이 길이 초과일 경우 예외 발생")
    public void testCarNameOverLength() {
        CarNameValidator.validateCarName("precourse");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름에 기호가 들어가면 예외 발생")
    public void testCarNameHasMark() {
        CarNameValidator.validateCarName("po*&");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름에 공백이 들어가면 예외 발생")
    public void testCarNameHasSpace() {
        CarNameValidator.validateCarName("p  p");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("아무것도 입력되지 않으면 예외 발생")
    public void testNoAnyInput() {
        CarNameValidator.validateCarName("");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름이 중복되면 예외 발생")
    public void testDuplication() {
        CarNameValidator.validateCarName("pobi,woni,pobi");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("쉼표가 연속되면 예외 발생")
    public void testDelimIsSerial() {
        CarNameValidator.validateCarName("pobi,,woni");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("쉼표가 맨 앞에 오면 예외 발생")
    public void testStartWithDelim() {
        CarNameValidator.validateCarName(",pobi,woni");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("쉼표가 맨 뒤에 오면 예외 발생")
    public void testEndWithDelim() {
        CarNameValidator.validateCarName("pobi,woni,");
    }
}
