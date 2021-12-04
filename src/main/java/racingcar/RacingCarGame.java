package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Condition;
import racingcar.view.OutputView;

public class RacingCarGame {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 1자 이상, 5자 이하로 작성해야 합니다.";
    private static final String INPUT_TIMES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INPUT_TIMES_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상의 숫자여야 합니다.";
    private ArrayList<Car> cars;

    public void start() {
        inputCarName();
        int times = inputTimes();

        OutputView outputView = new OutputView();
        for (int t = 0; t < times; t++) {
            progress(cars);
            outputView.showCurrentPosition(cars);
        }
    }

    public void inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");

        cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> cars.add(new Car(name)));
        validateCarName(cars);
    }

    public void validateCarName(ArrayList<Car> cars) {
        try {
            for (Car car : cars) {
                car.isNameNull(car.getName());
                car.isNameOutOfRange(car.getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_CAR_NAME_ERROR_MESSAGE);
            inputCarName();
        }
    }

    public int inputTimes() {
        while (true) {
            System.out.println(INPUT_TIMES_MESSAGE);
            String timesInput = Console.readLine();
            try {
                validateTimes(timesInput);
                return Integer.parseInt(timesInput);
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_TIMES_ERROR_MESSAGE);
            }
        }
    }

    public void validateTimes(String timesInput) throws IllegalArgumentException {
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

    public void progress(ArrayList<Car> cars) {
        cars.stream()
                .forEach(car -> car.forward(Randoms.pickNumberInRange(0, 9)));
    }
}

