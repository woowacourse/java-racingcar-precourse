package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

import static racingcar.validation.ErrorCode.*;
import static racingcar.validation.ErrorCode.IS_DUPLICATED;

public class CarNamesValidator {
    private static final String BY = ",";

    public static String checkNamesAndReturn(String input) {
        isNull(input);
        isCommaOrAlphabet(input);
        isProperLength(input);
        hasDuplicatedName(input);

        return input;
    }

    private static void isNull(String input) {
        if (input.isEmpty())
            throw new IllegalArgumentException(IS_NULL.getDetail());
    }


    private static void isCommaOrAlphabet(String target) {
        for (char c : target.toCharArray()) {
            validateEachChar(c);
        }
    }

    private static void validateEachChar(char c) {
        if (c != ',' && !Character.isAlphabetic(c))
            throw new IllegalArgumentException(NOT_ALLOW_CHAR.getDetail());
    }

    private static void isProperLength(String target) {
        for (String eachName : target.split(BY)) {
            validateEachNameLength(eachName);
        }
    }

    private static void validateEachNameLength(String target) {
        if (target.length() < 1 || target.length() > 5)
            throw new IllegalArgumentException(NOT_ALLOW_LENGTH.getDetail());
    }

    private static void hasDuplicatedName(String target) {
        Set<String> nameSet = new HashSet<>();

        for (String eachName : target.split(BY)) {
            validateEachNameIsDuplicated(nameSet, eachName);
            nameSet.add(eachName);
        }
    }

    private static void validateEachNameIsDuplicated(Set<String> nameSet, String name) {
        if (nameSet.contains(name))
            throw new IllegalArgumentException(IS_DUPLICATED.getDetail());
    }
}
