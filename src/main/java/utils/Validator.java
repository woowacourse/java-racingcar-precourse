package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final String SEPARATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분되어야합니다.";
    private static final String CAR_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야합니다.";
    private static final String NOT_NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String UNDER_ZERO_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 0보다 커야합니다.";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "[ERROR] 자동차 이름에 특수 문자는 허용되지 않습니다.";
    private static final String DUPLICATED_CAR_NAME_ERROR_MESSAGE = "[ERROR] 중복된 자동차 이름이 존재합니다.";
    private static final String CAR_NAME_PATTERN = "[0-9|a-z |A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝 ]*";
    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    public static void validateContainSeparator(String input) {
        if (!input.contains(RACING_CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATE_ERROR_MESSAGE);
        }
    }

    public static void validateContainSpecialCharacters(String name) {
        if (!Pattern.matches(CAR_NAME_PATTERN, name)) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    public static void validateCanSeparated(List<String> inputs) {
        if (inputs.size() == 0) {
            throw new IllegalArgumentException(SEPARATE_ERROR_MESSAGE);
        }
        for (String input : inputs) {
            if (input.length() == 0) {
                throw new IllegalArgumentException(SEPARATE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateContainDuplication(List<String> names) {
        Set<String> set = new HashSet<>();

        for (String name : names) {
            if (set.contains(name)) {
                throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE);
            }
            set.add(name);
        }
    }

    public static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() == 0) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public static void validateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == PLUS || input.charAt(i) == MINUS) {
                continue;
            }
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MESSAGE);
            }
        }
    }

    public static void validateOverZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(UNDER_ZERO_INPUT_ERROR_MESSAGE);
        }
    }

}
