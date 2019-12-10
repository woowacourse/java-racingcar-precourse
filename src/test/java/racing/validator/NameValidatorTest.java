package racing.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameValidatorTest {

    @Test
    public void 이름_점검_5자이하_영어문자_true() {
        boolean validNames = InputValidator.isValidNames("abcde,aBc,abb");
        assertEquals(validNames, true);
    }

    @Test
    public void 이름_점검_5자초과_영어문자_false() {
        boolean validNames = InputValidator.isValidNames("abcdde,aBc,abb");
        assertEquals(validNames, false);
    }

    @Test
    public void 이름_점검_숫자포함문자_false() {
        boolean validNames = InputValidator.isValidNames("abdde,aBc,abb,ab1");
        assertEquals(validNames, false);
    }

    @Test
    public void 이름_점검_한글포함문자_false() {
        boolean validNames = InputValidator.isValidNames("abcdd,aBc,a가bb,ab1");
        assertEquals(validNames, false);
    }

    @Test
    public void 이름_점검_한개데이터_true() {
        boolean validNames = InputValidator.isValidNames("abcdd");
        assertEquals(validNames, true);
    }

    @Test
    public void 이름_점검_특수포함문자_false() {
        boolean validNames = InputValidator.isValidNames("ab!dd,aBc,abb,ab1");
        assertEquals(validNames, false);
    }

    @Test
    public void 빈문자_false() {
        boolean validNames = InputValidator.isValidNames("");
        assertEquals(validNames, false);
    }
}