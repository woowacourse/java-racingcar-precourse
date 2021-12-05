package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import racingcar.constant.Condition;
import racingcar.domain.Car;

class RacingCarGameTest {

    private void validateTimes(String timesInput) throws IllegalArgumentException {
        for (int i = 0; i < timesInput.length(); i++) {
            if (!Character.isDigit(timesInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if (timesInput.length() < Condition.MINIMUM_CAR_MOVE_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(timesInput) < Condition.MINIMUM_CAR_MOVE_TIMES) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    void 자동차_이름_입력_예외() {
        String[] carNames = {"Mike Wazowski", ""};
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));

        assertThrows(IllegalArgumentException.class, () -> cars.get(0).isNameOutOfRange(cars.get(0).getName()));
        assertThrows(IllegalArgumentException.class, () -> cars.get(1).isNameNull(cars.get(1).getName()));
    }

    @Test
    void 자동차_전진_시도_횟수() {
        assertThrows(IllegalArgumentException.class, () -> validateTimes(""));
        assertThrows(IllegalArgumentException.class, () -> validateTimes("0"));
        assertThrows(IllegalArgumentException.class, () -> validateTimes("d"));

        assertDoesNotThrow(() -> validateTimes("10"));
        assertDoesNotThrow(() -> validateTimes("1"));
        assertDoesNotThrow(() -> validateTimes("999"));
    }
}
