package racingcar.car;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import view.OutputView;

public class CarNames {
    public static final String NAME_SEPARATOR = ",";
    public static final String DEFAULT_SEPARATOR = "";
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void validate(String rawCarNames) {
        validateNotAllComma(rawCarNames);
        validateNameCommaCountMatch(rawCarNames);
        validateHasName(rawCarNames);
        validateProperLength(rawCarNames);
        validateNoDuplicate(rawCarNames);
    }

    private static void validateNotAllComma(String rawCarNames) {
        if (isAllComma(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean isAllComma(String rawCarNames) {
        return Stream.of(rawCarNames.split(DEFAULT_SEPARATOR))
                .allMatch(CarNames::isComma);
    }

    private static boolean isComma(String targetString) {
        return targetString.equals(NAME_SEPARATOR);
    }

    // rawCarNames should have n amount of names and n - 1 amount of commas
    // ex: name1,name2,name3 (3 names and 2 commas)
    private static void validateNameCommaCountMatch(String rawCarNames) {
        if (nameCommaCountNotMatching(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean nameCommaCountNotMatching(String rawCarNames) {
        int nameCount = (int) Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .count();
        int commaCount = (int) Stream.of(rawCarNames.split(DEFAULT_SEPARATOR))
                .filter(x -> x.equals(NAME_SEPARATOR))
                .count();
        return nameCount - 1 != commaCount;
    }

    private static void validateHasName(String rawCarNames) {
        if (hasNoName(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.NO_NAME_ERROR);
        }
    }

    private static boolean hasNoName(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(CarNames::lengthIsZero);
    }

    private static boolean lengthIsZero(String name) {
        return name.length() == 0;
    }

    private static void validateProperLength(String rawCarNames) {
        if (hasNameExceedingLength(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.EXCEEDING_LENGTH_ERROR);
        }
    }

    private static boolean hasNameExceedingLength(String rawCarNames) {
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(CarNames::exceedMaximumLength);
    }

    private static boolean exceedMaximumLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

    private static void validateNoDuplicate(String rawCarNames) {
        if (hasDuplicate(rawCarNames)) {
            throw new IllegalArgumentException(OutputView.HAS_DUPLICATE_ERROR);
        }
    }

    private static boolean hasDuplicate(String rawCarNames) {
        Set<String> noDuplicateNames = new HashSet<>();
        return Stream.of(rawCarNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .anyMatch(x -> !noDuplicateNames.add(x));
    }
}
