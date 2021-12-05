package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Condition;
import racingcar.constant.Input;
import racingcar.view.OutputView;

public class RacingCarGame {
    private ArrayList<Car> cars;

    public void start() {
        inputCarName();
        int times = inputTimes();

        OutputView outputView = new OutputView();
        for (int t = 0; t < times; t++) {
            progress(cars);
            outputView.showCurrentPosition(cars);
        }
        outputView.showWinnerCarName(cars);
    }

    private void inputCarName() {
        System.out.println(Input.CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");

        cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));
        validateCarName(cars);
    }

    private void validateCarName(ArrayList<Car> cars) {
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

    private int inputTimes() {
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

    private void progress(ArrayList<Car> cars) {
        cars.stream()
                .forEach(car -> car.forward(Randoms.pickNumberInRange(0, 9)));
    }
}

