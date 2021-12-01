package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingSystemTest {
    @Test
    void 자동차_입력_예외_발생() {
        RacingSystem system = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> system.checkValidName("A,B,")
        );
    }

    @Test
    void 올바른_자동차_입력() {
        RacingSystem system = new RacingSystem();
        assertDoesNotThrow(() -> system.checkValidName("car1,car2,car3"));
    }

    @Test
    void 숫자_입력_예외_발생() {
        RacingSystem system = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> system.checkNumber("12A")
        );
    }

    @Test
    void 올바른_숫자_입력() {
        RacingSystem system = new RacingSystem();
        assertDoesNotThrow(() -> system.checkNumber("123"));
    }
}