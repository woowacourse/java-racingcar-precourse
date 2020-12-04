package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER_COMMA = ",";
    private static final String ONLY_INPUT_NUMBER_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INPUT_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static Cars inputCarNames(Scanner scanner) {
        System.out.println(INPUT_RACING_CAR_NAMES_MESSAGE);
        String carNames = scanner.nextLine();
        try {
            return new Cars(
                    Arrays.stream(carNames.split(DELIMITER_COMMA))
                            .map(String::trim)
                            .map(Car::new)
                            .collect(Collectors.toList())
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    public static TryNumber inputTryNumber(Scanner scanner) {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        String tryNumber = scanner.nextLine();
        System.out.println();

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
