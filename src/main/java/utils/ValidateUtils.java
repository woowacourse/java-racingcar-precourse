package utils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import view.OutputView;

public class ValidateUtils {

    public static final String NAME_SEPARATOR = ",";
    public static final String DEFAULT_SEPARATOR = "";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMAL_ROUND_COUNT = 1;

    public static void validateRoundCount(String rawRoundCount) {
        validateNumeric(rawRoundCount);
        validateAtLeastMinimalRoundCount(rawRoundCount);
    }

    private static void validateAtLeastMinimalRoundCount(String rawRoundCount) {
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
        validateNotAllComma(rawCarNames);
        validateNameCommaCountEqual(rawCarNames);
        validateNoName(rawCarNames);
        validateProperLength(rawCarNames);
        validateNoDuplicate(rawCarNames);
    }

    private static void validateNoDuplicate(String rawCarNames) {
        if(hasDuplicate(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.HAS_DUPLICATE_ERROR);
        }
    }

    private static boolean hasDuplicate(String rawCarNames) {
        Set<String> noDuplicateNames = new HashSet<>();
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(x -> !noDuplicateNames.add(x));
    }

    private static void validateNameCommaCountEqual(String rawCarNames) {
        if(nameCommaCountNotEqual(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean nameCommaCountNotEqual(String rawCarNames) {
        int nameCount = (int)Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .count();
        int commaCount = (int)Stream.of(rawCarNames.split(DEFAULT_SEPARATOR))
                .filter(x -> x.equals(NAME_SEPARATOR))
                .count();
        return nameCount - 1 != commaCount;
    }

    private static void validateNotAllComma(String rawCarNames) {
        if (isAllComma(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean isAllComma(String rawCarNames) {
        return Stream.of(rawCarNames.split(DEFAULT_SEPARATOR))
                .allMatch(ValidateUtils::isComma);
    }

    private static boolean isComma(String targetString) {
        return targetString.equals(NAME_SEPARATOR);
    }

    private static void validateProperLength(String rawCarNames) {
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
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(ValidateUtils::lengthIsZero);
    }

    private static boolean hasNameExceedingLength(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(ValidateUtils::exceedMaximumLength);
    }

    private static boolean exceedMaximumLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

    private static boolean lengthIsZero(String name) {
        return name.length() == 0;
    }
}
