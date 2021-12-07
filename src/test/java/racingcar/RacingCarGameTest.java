package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import racingcar.constant.Condition;
import racingcar.constant.Input;
import racingcar.domain.Car;

class RacingCarGameTest {

    private void validateTimes(String timesInput) throws IllegalArgumentException {
        for (int i = 0; i < timesInput.length(); i++) {
            if (!Character.isDigit(timesInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        isTimesNull(timesInput.length());
        isTimesZero(Integer.parseInt(timesInput));
    }

    private void isTimesNull(int timesLength) throws IllegalArgumentException {
        if (timesLength < Condition.MINIMUM_CAR_MOVE_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isTimesZero(int times) throws IllegalArgumentException {
        if (times < Condition.MINIMUM_CAR_MOVE_TIMES) {
            throw new IllegalArgumentException();
        }
    }

    private void hasSameCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        HashSet<String> carNameSet = new HashSet<>();
        for (Car car : cars) {
            carNameSet.add(car.getName());
        }
        if (cars.size() != carNameSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void isNameOutOfRange(String carName) throws IllegalArgumentException {
        if (carName.length() > Condition.MAXIMUM_CAR_NAME_INPUT_LENGTH) {
            System.out.println(Input.CAR_NAME_ABOVE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void isNameNull(String carName) throws IllegalArgumentException {
        if (carName.length() < Condition.MINIMUM_CAR_NAME_INPUT_LENGTH) {
            System.out.println(Input.CAR_NAME_BELOW_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    @Test
    void 자동차_이름_입력_예외() {
        String[] carNames = {"Mike Wazowski", ""};
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));

        assertThrows(IllegalArgumentException.class, () -> isNameOutOfRange(cars.get(0).getName()));
        assertThrows(IllegalArgumentException.class, () -> isNameNull(cars.get(1).getName()));
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

    @Test
    void 자동차_이름_중복_예외() {
        String[] carNames = {"Mike", "Mike", "James"};
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));
        assertThrows(IllegalArgumentException.class, () -> hasSameCarName(cars));
    }
}
