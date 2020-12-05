package racingcar;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CarValidatorTest {
    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름이 길이 초과일 경우 예외 발생")
    public void testCarNameOverLength() {
        CarValidator.checkNotOverLengthOf("precourse");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름에 기호가 들어가면 예외 발생")
    public void testCarNameHasMark() {
        CarValidator.checkRightFormatOf("po*&");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름에 공백이 들어가면 예외 발생")
    public void testCarNameHasSpace() {
        CarValidator.checkRightFormatOf("p  p");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("아무것도 입력되지 않으면 예외 발생")
    public void testNoAnyInput() {
        CarValidator.checkRightFormatOf("");
    }

    @Test(expected = IllegalCarNameException.class)
    @DisplayName("이름이 중복되면 예외 발생")
    public void testDuplication() {
        CarValidator.validateDuplication("pobi,woni,pobi");
    }
}
