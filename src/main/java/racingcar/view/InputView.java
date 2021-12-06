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

    public ArrayList<Car> inputCarName() {
        System.out.println(Input.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");
        cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(name -> cars.add(new Car(name)));
        while (true) {
            try {
                validateCarName(cars);
                hasSameCarName(cars);
                return cars;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void validateCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        try {
            for (Car car : cars) {
                car.isNameNull(car.getName());
                car.isNameOutOfRange(car.getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Input.CAR_NAME_ERROR_MESSAGE);
            inputCarName();
        }
    }

    private void hasSameCarName(ArrayList<Car> cars) throws IllegalArgumentException {
        HashSet<String> carNameSet = new HashSet<>();
        try {
            for (Car car : cars) {
                carNameSet.add(car.getName());
            }
            if (cars.size() != carNameSet.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Input.OVERLAP_ERROR_MESSAGE);
            inputCarName();
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
