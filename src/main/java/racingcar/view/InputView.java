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

    private ArrayList<Car> carNameInputInit () {
        System.out.println(Input.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");

        cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(name -> cars.add(new Car(name)));
        return cars;
    }

    public ArrayList<Car> validateCarNameInput() {
        while (true) {
            cars = carNameInputInit();

            try {
                hasOnlyComma(cars);
                hasSameCarName(cars);
                isNameOutOfRange(cars);
                isNameNull(cars);
                return cars;
            } catch (IllegalArgumentException e) {
            }
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

    private void isNameOutOfRange(ArrayList<Car> cars) throws IllegalArgumentException {
        for (Car car : cars) {
            if (car.getName().length() > Condition.MAXIMUM_CAR_NAME_INPUT_LENGTH) {
                System.out.println(Input.CAR_NAME_ABOVE_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void isNameNull(ArrayList<Car> cars) throws IllegalArgumentException {
        for (Car car : cars) {
            if (car.getName().length() < Condition.MINIMUM_CAR_NAME_INPUT_LENGTH) {
                System.out.println(Input.CAR_NAME_BELOW_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private String timesInputInit() {
        System.out.println(Input.TIMES_MESSAGE);
        String timesInput = Console.readLine();
        return timesInput;
    }

    public int validateTimesInput() {
        while (true) {
            String timesInput = timesInputInit();

            try {
                isTimesDigit(timesInput);
                isTimesNull(timesInput.length());
                isTimesZero(Integer.parseInt(timesInput));
                return Integer.parseInt(timesInput);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void isTimesDigit(String timesInput) throws IllegalArgumentException {
        for (int i = 0; i < timesInput.length(); i++) {
            if (!Character.isDigit(timesInput.charAt(i))) {
                System.out.println(Input.TIMES_UN_DIGIT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
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