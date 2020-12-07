package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    public void isAppropriateNumber() {
        String input = "10";
        Number number = new Number(input);

        assertThat(10).isEqualTo(number.getTryNumber());
    }

    @Test
    public void isUnappropriatedNumber() {
        String input = "abd";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number(input));

        assertThat("[ERROR] 0이상의 숫자를 입력하세요.").isEqualTo(exception.getMessage());
    }
}