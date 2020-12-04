package racingcar.view;

import racingcar.domain.Car;

import racingcar.domain.Cars;
import racingcar.domain.Rule;
import utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static Cars inputCarNames(Scanner scanner) {
        try {
            System.out.println(INPUT_CAR_NAMES_MESSAGE);
            String inputCarNames = InputValidator.validateInputCarNames(scanner.nextLine());
            String[] carNames = inputCarNames.split(",");
            List<Car> cars = new ArrayList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    public static Rule inputAttemptNumber(Scanner scanner) {
        try {
            System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
            return new Rule(InputValidator.validateInteger(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAttemptNumber(scanner);
        }
    }
}
