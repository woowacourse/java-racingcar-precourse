//package validator;
//
//import static org.junit.Assert.*;
//
//import annotation.TestDescription;
//import org.junit.Test;
//
//public class InputValidatorTest {
//    private static final int ENOUGH_BIG_NUMBER = 1000000;
//
//    @Test
//    @TestDescription("0이 입력되는 경우 정상적으로 True를 리턴하는지 테스트합니다.")
//    public void checkItIsZeroTest() {
//        assertTrue(InputValidator.checkItIsZero(0));
//        for (int i = 1; i < ENOUGH_BIG_NUMBER; i++) {
//            assertFalse(InputValidator.checkItIsZero(i));
//        }
//        assertFalse(InputValidator.checkItIsZero(-1));
//        assertFalse(InputValidator.checkItIsZero(-3));
//    }
//
//    @Test
//    @TestDescription("자동차 이름이 적절한지 테스트합니다.")
//    public void checkCarNameTest() {
//        InputValidator inputValidator = new InputValidator();
//
//        String[] carNames = {"name", "hello", "world"};
//        assertTrue(inputValidator.checkCarNames(carNames));
//        String[] carNames4 = {"     asdas      ", "        asdaa ", "world"};
//        assertTrue(inputValidator.checkCarNames(carNames4));
//        String[] carNames2 = {"", "hello", "world"};
//        assertFalse(inputValidator.checkCarNames(carNames2));
//        String[] carNames3 = {"helloBro", "hello", "world"};
//        assertFalse(inputValidator.checkCarNames(carNames3));
//        String[] carNames5 = {"sdof'''..sdf[23-04"};
//        assertFalse(inputValidator.checkCarNames(carNames5));
//    }
//}