package utils;

import java.util.stream.Stream;
import view.OutputView;

public class ValidateUtils {

    public static final String NAME_SEPARATOR = ",";
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMAL_ROUND_COUNT = 1;

    public static void validateRoundCount(String rawRoundCount) {
        validateNumeric(rawRoundCount);
        validateBiggerThanMinimalRoundCount(rawRoundCount);
    }

    private static void validateBiggerThanMinimalRoundCount(String rawRoundCount) {
        if (isLessThanMinimalRoundCount(rawRoundCount)) {
            throw new IllegalArgumentException(OutputView.IS_SMALLER_THAN_MINIMAL_ERROR);
        }
    }

    private static boolean isLessThanMinimalRoundCount(String rawRoundCount) {
        return Integer.parseInt(rawRoundCount) < MINIMAL_ROUND_COUNT;
    }

    private static void validateNumeric(String rawRoundCount) {
        try {
            Integer.parseInt(rawRoundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.NOT_NUMBER_ERROR);
        }
    }

    public static void validateCarNames(String rawCarNames) {
        validateNoName(rawCarNames);
        validateExceedingLength(rawCarNames);
    }

    private static void validateExceedingLength(String rawCarNames) {
        if (hasNameExceedingLength(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.EXCEEDING_LENGTH_ERROR);
        }
    }

    private static void validateNoName(String rawCarNames) {
        if (hasNoName(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean hasNoName(String rawCarNames) {
        return rawCarNames.length() < MINIMUM_NAME_LENGTH;
    }

    private static boolean hasNameExceedingLength(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .anyMatch(ValidateUtils::exceedMaximumLength);
    }

    private static boolean exceedMaximumLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

}
