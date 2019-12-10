package racing.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoundValidatorTest {

    @Test
    public void 라운드입력_테스트_양의정수_성공() {
        boolean validResult = InputValidator.isValidRound("3");
        assertEquals(true, validResult);
    }

    @Test
    public void 라운드입력_테스트_양의정수_3자리이상_실패() {
        boolean validResult = InputValidator.isValidRound("100");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_0_실패() {
        boolean validResult = InputValidator.isValidRound("0");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_음의정수_실패() {
        boolean validResult = InputValidator.isValidRound("-1");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_숫자가_아닌_경우_실패() {
        boolean validResult = InputValidator.isValidRound("A");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_숫자가_아닌_경우_실패2() {
        boolean validResult = InputValidator.isValidRound("가");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_숫자가_아닌_경우_실패3() {
        boolean validResult = InputValidator.isValidRound("3.0");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_숫자가_아닌_경우_실패4() {
        boolean validResult = InputValidator.isValidRound("true");
        assertEquals(false, validResult);
    }

    @Test
    public void 라운드입력_테스트_숫자가_아닌_경우_실패5() {
        boolean validResult = InputValidator.isValidRound("312df");
        assertEquals(false, validResult);
    }
}