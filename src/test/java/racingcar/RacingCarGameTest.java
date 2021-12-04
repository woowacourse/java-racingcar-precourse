package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @Test
    public void 자동차_이름_입력_예외() {
        String[] carNames = {"Mike Wazowski", ""};
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));

        assertThrows(IllegalArgumentException.class, () -> cars.get(0).isNameOutOfRange(cars.get(0).getName()));
        assertThrows(IllegalArgumentException.class, () -> cars.get(1).isNameNull(cars.get(1).getName()));
    }

    @Test
    public void 자동차_전진_시도_횟수() {
        RacingCarGame racingCarGame = new RacingCarGame();

        assertThrows(IllegalArgumentException.class, () -> racingCarGame.validateTimes(""));
        assertThrows(IllegalArgumentException.class, () -> racingCarGame.validateTimes("0"));
        assertThrows(IllegalArgumentException.class, () -> racingCarGame.validateTimes("d"));

        assertDoesNotThrow(() -> racingCarGame.validateTimes("10"));
        assertDoesNotThrow(() -> racingCarGame.validateTimes("1"));
        assertDoesNotThrow(() -> racingCarGame.validateTimes("999"));
    }
}
