package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_TO_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DEFAULT_DELIMITER_OF_CAR_NAMES = ",";
    private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
    public static final String ERROR_MESSAGE_FOR_INVALID_CAR_NAME_LENGTH = "[ERROR] 이름은 5자 이하만 가능하다 : ";

    public static String[] getCarNames() {
        System.out.println(MESSAGE_TO_GET_CAR_NAMES);
        String carNameInput = Console.readLine();

        try {
            validateCarNameLength(carNameInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }

        return carNameInput.split(DEFAULT_DELIMITER_OF_CAR_NAMES);
    }

    private static void validateCarNameLength(String carNameInput) {
        String[] carNames = carNameInput.split(DEFAULT_DELIMITER_OF_CAR_NAMES);
        String invalidLengthNames = Arrays.stream(carNames)
                .filter(e -> e.length() > MAXIMUM_LENGTH_OF_CAR_NAME || e.isEmpty())
                .collect(Collectors.joining(DEFAULT_DELIMITER_OF_CAR_NAMES));

        if (invalidLengthNames.isEmpty()) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_CAR_NAME_LENGTH + invalidLengthNames);
    }
}
