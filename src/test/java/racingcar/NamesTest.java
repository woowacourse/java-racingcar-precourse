package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
class NamesTest {
    Names names = new Names();

    @Test
    @DisplayName("이름이 존재하지 않을 경우")
    void nameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> names.validate(""));
        assertThrows(IllegalArgumentException.class, () -> names.validate(","));
        assertThrows(IllegalArgumentException.class, () -> names.validate("a,b,d,"));
        assertThrows(IllegalArgumentException.class, () -> names.validate(",,,,"));
    }

    @Test
    @DisplayName("이름에 공백이 존재하는 경우")
    void existWhitespace() {
        assertThrows(IllegalArgumentException.class, () -> names.validate(" , "));
        assertThrows(IllegalArgumentException.class, () -> names.validate("\t, "));
        assertThrows(IllegalArgumentException.class, () -> names.validate("yh h"));
    }

    @Test
    @DisplayName("이름이 중복될 경우")
    void duplicateName() {
        assertThrows(IllegalArgumentException.class, () -> names.validate("yhh,yhh"));
    }

    @Test
    @DisplayName("이름이 5글자가 넘는 경우")
    void invalidNameLength() {
        assertThrows(IllegalArgumentException.class,
                () -> names.validate("user1234,user"));
    }

    @Test
    @DisplayName("참가자가 30명이 넘을 경우")
    void invalidNamesSize() {
        String invalidNames = "y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y,y";

        assertThrows(IllegalArgumentException.class, () -> names.validate(invalidNames));
    }
}
