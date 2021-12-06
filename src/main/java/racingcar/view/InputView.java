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

    private String[] inputInit () {
        System.out.println(Input.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return carNames;
    }

    public ArrayList<Car> validateInput() {
        String[] carNames = inputInit();
        cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(name -> cars.add(new Car(name)));

        while (true) {
            try {
                hasOnlyComma(cars);
                validateCarName(cars);
                hasSameCarName(cars);
                return cars;
            } catch (IllegalArgumentException e) {
                validateInput();
            }
        }
    }

    private void validateCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        for (Car car : cars) {
            car.isNameNull(car.getName());
            car.isNameOutOfRange(car.getName());
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

    public int inputTimes() {
        while (true) {
            System.out.println(Input.TIMES_MESSAGE);
            String timesInput = Console.readLine();
            try {
                validateTimes(timesInput);
                return Integer.parseInt(timesInput);
            } catch (IllegalArgumentException e) {
                System.out.println(Input.TIMES_ERROR_MESSAGE);
            }
        }
    }

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
}
