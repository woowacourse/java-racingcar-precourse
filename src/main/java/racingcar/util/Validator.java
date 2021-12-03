package racingcar.util;

import java.util.LinkedHashSet;
import java.util.StringTokenizer;

import static racingcar.constant.Constraint.*;
import static racingcar.constant.Message.*;

public class Validator {
    public static LinkedHashSet<String> carNameLinkedHashSet = new LinkedHashSet<>();

    public static void isValidInput(String input) {
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
