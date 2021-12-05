package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputSystemTest {
    private InputSystem system;
    private List<Car> cars;

    @BeforeEach
    void initial() {
        system = new InputSystem();
        cars = new ArrayList<>();
    }

    @Test
    void 자동차_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> system.checkValidName("A,B,", cars, "[ERROR]")
        );
    }

    @Test
    void 올바른_자동차_입력() {
        assertDoesNotThrow(() -> system.checkValidName("car1,car2,car3", cars, "[ERROR]"));
    }

    @Test
    void 숫자_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> system.checkNumber("12A", "[ERROR]")
        );
    }

    @Test
    void 올바른_숫자_입력() {
        InputSystem system = new InputSystem();
        assertDoesNotThrow(() -> system.checkNumber("123", "[ERROR]"));
    }
}