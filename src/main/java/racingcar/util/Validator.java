package racingcar.util;

import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ALLOWED_CAR_NAME_INPUT_FORMAT = "^[a-zA-Z]+(,[a-zA-Z]+)+$";
    private static final String ALLOWED_ROUND_NUMBER_INPUT_FORMAT = "^[1-9][0-9]*$";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차 이름이 있습니다";
    private static final String CAR_NAME_LENGTH_TOO_LONG_MESSAGE = "각 자동차 이름은 5 글자 이하로 제한됩니다.";
    private static final String LIMITED_TO_NUMBER_ONLY_MESSAGE = "숫자로만 제한됩니다.";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 형식입니다. 영문 이름,영문 이름,영문 이름 형식으로";

    public static LinkedHashSet<String> carNameLinkedHashSet = new LinkedHashSet<>();

    public static void validateNamesInput(String input) {
        if (!input.matches(ALLOWED_CAR_NAME_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_MESSAGE + RETRY_MESSAGE);
        }
    }

    public static LinkedHashSet<String> validateCarName(StringTokenizer stringTokenizer) throws IllegalArgumentException {
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            validateNameLength(nextToken);
            validateDuplicateName(nextToken);
            carNameLinkedHashSet.add(nextToken);
        }

        return carNameLinkedHashSet;
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAR_NAME_LENGTH_TOO_LONG_MESSAGE + RETRY_MESSAGE);
        }
    }

    private static void validateDuplicateName(String nextToken) {
        if (carNameLinkedHashSet.contains(nextToken)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_CAR_NAME_MESSAGE + RETRY_MESSAGE);
        }
    }

    public static Integer validateNumber(String input) {
        if (!input.matches(ALLOWED_ROUND_NUMBER_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LIMITED_TO_NUMBER_ONLY_MESSAGE + RETRY_MESSAGE);
        }

        return Integer.parseInt(input);
    }
}
