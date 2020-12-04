package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER_COMMA = ",";
    private static final String ONLY_INPUT_NUMBER_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<Car> inputCarNames(Scanner scanner) {
        String carNames = scanner.nextLine();

        try {
            return Arrays.stream(carNames.split(DELIMITER_COMMA))
                    .map(String::trim)
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    public static TryNumber inputTryNumber(Scanner scanner) {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        String tryNumber = scanner.nextLine();

        try {
            validateTryNumberType(tryNumber);

            return new TryNumber(Integer.parseInt(tryNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryNumber(scanner);
        }
    }

    private static void validateTryNumberType(String tryNumber) {
        boolean numberTypeOk = tryNumber.chars()
                .allMatch(Character::isDigit);

        if (!numberTypeOk) {
            throw new IllegalArgumentException(ONLY_INPUT_NUMBER_MESSAGE);
        }
    }
}
