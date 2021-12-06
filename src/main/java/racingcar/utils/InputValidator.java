package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String ERR_INVALID_FORMAT = ERROR_PREFIX + "잘못된 형식의 입력입니다!";
    private static final String ERR_INVALID_NUMBER = ERROR_PREFIX + "숫자만 입력해주세요.";
    private static final String ERR_DUPLICATED_NAME = ERROR_PREFIX + "중복된 이름이 있습니다.";
    private static final String ERR_INVALID_NAMES = ERROR_PREFIX + "이름은 1자 이상 5자 이하로 입력해주세요.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final char DELIMITER_NAME_CHAR = ',';
    private static final String NUMERIC_REGEX = "[0-9]";

    public static void validateCarNames(String input)
        throws IllegalArgumentException {
        List<String> names = Arrays.asList(input.split(String.valueOf(DELIMITER_NAME_CHAR)));
        validateFormat(input, names);
        validateNames(names);
        validateDuplicate(names);
    }

    public static void validatePlayCount(String playCount)
        throws IllegalArgumentException {
        if (!playCount.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(ERR_INVALID_NUMBER);
        }
    }

    private static void validateNames(List<String> names) {
        if (names.stream().allMatch(name ->
            !name.isEmpty() && name.length() <= NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(ERR_INVALID_NAMES);
        }
    }

    private static void validateFormat(String name, List<String> names) {
        if (name.chars()
            .filter(c -> c == DELIMITER_NAME_CHAR)
            .count() + 1 == names.size()) {
            throw new IllegalArgumentException(ERR_INVALID_FORMAT);
        }
    }

    private static void validateDuplicate(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ERR_DUPLICATED_NAME);
        }
    }
}
