package racingcar;

import static racingcar.Constants.DIVIDER_FOR_SPLIT;
import static racingcar.Constants.MAX_ATTEMPT;
import static racingcar.Constants.MAX_CAR_NAME_LENGTH;
import static racingcar.Constants.MIN_ATTEMPT;
import static racingcar.Constants.MIN_CAR_NAME_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UtilityFunctions {

    private UtilityFunctions() {
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            final String errorMessage = String.format(
                ErrorMessage.INVALID_CAR_NAME_LENGTH.toString(),
                MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateCarNameArrayDuplicate(String[] carNameArray) {
        final Set<String> carNameSet = new HashSet<>(Arrays.asList(carNameArray));
        if (carNameSet.size() != carNameArray.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.toString());
        }
    }

    public static String[] parseCarNameArrayString(String carNameArrayString) {
        final String[] carNameArray = carNameArrayString.split(DIVIDER_FOR_SPLIT, -1);
        for (final String carName : carNameArray) {
            validateCarNameLength(carName);
        }
        validateCarNameArrayDuplicate(carNameArray);
        return carNameArray;
    }

    private static void validateMaxAttemptStringFormat(String maxAttemptString) {
        // 숫자를 제외한 문자들로 문자열을 만들어, 해당 문자열의 길이가 0이 아닌지 확인
        final String stringForValidation = maxAttemptString.replaceAll("[0-9]", "");
        if (stringForValidation.length() != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_ATTEMPT_STRING_FORMAT.toString()
            );
        }
    }

    private static void validateMaxAttemptStringInteger(String maxAttemptString) {
        try {
            Integer.parseInt(maxAttemptString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_ATTEMPT_INTEGER.toString()
            );
        }
    }

    private static void validateMaxAttemptStringRange(String maxAttemptString) {
        final int maxAttempt = Integer.parseInt(maxAttemptString);
        if (maxAttempt < MIN_ATTEMPT || maxAttempt > MAX_ATTEMPT) {
            final String errorMessage = String.format(
                ErrorMessage.INVALID_ATTEMPT_RANGE.toString(), MIN_ATTEMPT, MAX_ATTEMPT
            );
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int parseMaxAttemptString(String maxAttemptString) {
        validateMaxAttemptStringFormat(maxAttemptString);
        validateMaxAttemptStringInteger(maxAttemptString);
        validateMaxAttemptStringRange(maxAttemptString);
        return Integer.parseInt(maxAttemptString);
    }
}
