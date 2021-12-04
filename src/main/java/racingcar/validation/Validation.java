package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

import static racingcar.validation.ErrorCode.*;

public class Validation {
    private static final String BY = ",";
    private static final int ZERO = 0;

    public static String inputCarNames(String input) {
        isNull(input);
        isCommaOrAlphabet(input);
        isProperLength(input);
        hasDuplicatedName(input);

        return input;
    }

    public static int inputRoundCount(String input) {
        isNull(input);
        isNumber(input);
        isZero(input);

        return Integer.parseInt(input);
    }

    private static void isNull(String input) {
        if(input.isEmpty())
            throw new IllegalArgumentException(IS_NULL.getDetail());
    }

    private static void isCommaOrAlphabet(String target) {
        for(char c : target.toCharArray()) {
            validateChar(c);
        }
    }

    private static void validateChar(char c) {
        if(c != ',' && !Character.isAlphabetic(c))
            throw new IllegalArgumentException(NOT_ALLOW_CHAR.getDetail());
    }

    private static void isProperLength(String target) {
        for(String eachName : target.split(BY)) {
            validateLength(eachName);
        }
    }

    private static void validateLength(String target) {
        if(target.length() < 1 || target.length() > 5)
            throw new IllegalArgumentException(NOT_ALLOW_LENGTH.getDetail());
    }

    private static void hasDuplicatedName(String target) {
        Set<String> nameSet = new HashSet<>();

        for(String eachName : target.split(BY)) {
            validateDuplication(nameSet, eachName);
            nameSet.add(eachName);
        }
    }

    private static void validateDuplication(Set<String> nameSet, String name) {
        if(nameSet.contains(name))
            throw new IllegalArgumentException(IS_DUPLICATED.getDetail());
    }

    private static void isNumber(String target) {
        for(char each : target.toCharArray()) {
            validateNumber(each);
        }
    }

    private static void validateNumber(char each) {
        if(!Character.isDigit(each))
            throw new IllegalArgumentException(FOUND_NOT_NUMBER.getDetail());
    }

    private static void isZero(String target) {
        if(Integer.parseInt(target) == ZERO)
            throw new IllegalArgumentException(FOUNR_ZERO_ONLY.getDetail());
    }
}
