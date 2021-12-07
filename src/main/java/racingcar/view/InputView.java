package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Condition;
import racingcar.constant.Input;
import racingcar.domain.Car;

public class InputView {
    private ArrayList<Car> cars;

    private String[] carNameInputInit () {
        System.out.println(Input.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return carNames;
    }

    public ArrayList<Car> carNameInput() {
        String[] carNames = carNameInputInit();
        cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(name -> cars.add(new Car(name)));
        while (true) {
            try {
                hasOnlyComma(cars);
                validateCarName(cars);
                hasSameCarName(cars);
                return cars;
            } catch (IllegalArgumentException e) {
                carNameInput();
            }
        }
    }

    private void validateCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        for (Car car : cars) {
            isNameNull(car.getName());
            isNameOutOfRange(car.getName());
        }
    }

    private void hasSameCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        HashSet<String> carNameSet = new HashSet<>();
        for (Car car : cars) {
            carNameSet.add(car.getName());
        }
        if (cars.size() != carNameSet.size()) {
            System.out.println(Input.OVERLAP_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void hasOnlyComma(ArrayList<Car> cars) throws IllegalArgumentException {
        if (cars.size() == Condition.HAS_ONLY_COMMA) {
            System.out.println(Input.ONLY_COMMA_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isNameOutOfRange(String carName) throws IllegalArgumentException {
        if (carName.length() > Condition.MAXIMUM_CAR_NAME_INPUT_LENGTH) {
            System.out.println(Input.CAR_NAME_ABOVE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isNameNull(String carName) throws IllegalArgumentException {
        if (carName.length() < Condition.MINIMUM_CAR_NAME_INPUT_LENGTH) {
            System.out.println(Input.CAR_NAME_BELOW_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int timesInput() {
        while (true) {
            System.out.println(Input.TIMES_MESSAGE);
            String timesInput = Console.readLine();

            try {
                validateTimes(timesInput);
                return Integer.parseInt(timesInput);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void validateTimes(String timesInput) throws IllegalArgumentException {
        for (int i = 0; i < timesInput.length(); i++) {
            if (!Character.isDigit(timesInput.charAt(i))) {
                System.out.println(Input.TIMES_UN_DIGIT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
        isTimesNull(timesInput.length());
        isTimesZero(Integer.parseInt(timesInput));
    }

    private void isTimesNull(int timesLength) throws IllegalArgumentException {
        if (timesLength < Condition.MINIMUM_CAR_MOVE_INPUT_LENGTH) {
            System.out.println(Input.TIMES_BELOW_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isTimesZero(int times) throws IllegalArgumentException {
        if (times < Condition.MINIMUM_CAR_MOVE_TIMES) {
            System.out.println(Input.TIMES_ZERO_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}