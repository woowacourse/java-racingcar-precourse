package racingcar.view;

import racingcar.domain.exception.CarNameLengthException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_NOTICE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA_DELIMITER = ",";
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_NOTICE_MESSAGE);
        String[] inputCarNames = this.scanner.nextLine()
                .split(COMMA_DELIMITER);
        while (!isValidInputCarNames(inputCarNames)) {
            inputCarNames = this.scanner.nextLine()
                    .split(COMMA_DELIMITER);
        }
        return Arrays.stream(inputCarNames)
                .collect(Collectors.toList());
    }

    private boolean isValidInputCarNames(String[] inputCarNames) {
        try {
            validateInputCarNameLength(inputCarNames);
            return true;
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
            return false;
        }
    }

    private void validateInputCarNameLength(String[] inputCarNames) {
        boolean isAllValidLength = Arrays.stream(inputCarNames)
                .allMatch(this::isValidInputCarNameLength);
        if (!isAllValidLength) {
            throw new CarNameLengthException();
        }
    }

    private boolean isValidInputCarNameLength(String inputCarName) {
        return !inputCarName.isEmpty() && inputCarName.length() <= MAXIMUM_CAR_NAME_LENGTH;
    }
}
