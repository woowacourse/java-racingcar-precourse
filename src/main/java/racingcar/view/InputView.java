package racingcar.view;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import utils.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";

    private InputView() {
    }

    public static Cars inputCarNames(Scanner scanner) {
        try {
            System.out.println(INPUT_CAR_NAMES_MESSAGE);
            String inputCarNames = InputValidator.validateInputCarNames(scanner.nextLine());
            List<Car> cars = Arrays.stream(inputCarNames.split(COMMA))
                    .map(carName -> new Car(carName))
                    .collect(Collectors.toList());
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    public static AttemptNumber inputAttemptNumber(Scanner scanner) {
        try {
            System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
            return new AttemptNumber(InputValidator.validateInteger(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAttemptNumber(scanner);
        }
    }
}
