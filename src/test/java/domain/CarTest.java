package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private final static String LONG_NAME = "abcdef";
    private final static String EMPTY_NAME = "";
    private final static String TOO_LONG_NAME = "[ERROR] 이름은 5자 이하여야 합니다.";
    private final static String EMPTY_NAME_EXCEPTION = "[ERROR] 이름은 공백일 수 없습니다.";

    @Test
    public void makeLongNameCarTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(LONG_NAME);
        });
        Assertions.assertEquals(TOO_LONG_NAME, exception.getMessage());
    }

    @Test
    public void makeEmptyNameCarTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(EMPTY_NAME);
        });
        Assertions.assertEquals(EMPTY_NAME_EXCEPTION, exception.getMessage());
    }
}