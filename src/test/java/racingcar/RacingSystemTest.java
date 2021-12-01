package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingSystemTest {
    @Test
    void 예외_발생() {
        RacingSystem system = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> system.checkValid("A,B,")
        );
    }
}