package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    final private static String ERROR_PREFIX = "[ERROR]";
    final private static String ERR_INVALID_NAMES = ERROR_PREFIX + "잘못된 형식의 입력입니다!";
    final private static String ERR_INVALID_NUMBER = ERROR_PREFIX + "숫자만 입력해주세요.";
    final private static int NAME_MAX_LENGTH = 5;
    final private static char DELIMITER_NAME_CHAR = ',';
    final private static String NUMERIC_REGEX = "[0-9]";

    public static void validateCarNames(String input)
        throws IllegalArgumentException {
        List<String> names = Arrays.asList(input.split(String.valueOf(DELIMITER_NAME_CHAR)));
        if (!isValidFormat(input, names)
            || !isValidNames(names)
            || !isNonDuplicatedNames(names)) {
            throw new IllegalArgumentException(ERR_INVALID_NAMES);
        }
    }

    public static void validatePlayCount(String playCount)
        throws IllegalArgumentException {
        if (!isNumeric(playCount)) {
            throw new IllegalArgumentException(ERR_INVALID_NUMBER);
        }
    }

    private static boolean isNumeric(String number) {
        Pattern pattern = Pattern.compile(NUMERIC_REGEX);
        return pattern.matcher(number).matches();
    }

    private static boolean isValidNames(List<String> names) {
        return names.stream().allMatch(InputValidator::isValidName);
    }

    private static boolean isValidFormat(String name, List<String> names) {
        return name.chars()
            .filter(c -> c == DELIMITER_NAME_CHAR)
            .count() + 1 == names.size();
    }

    private static boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= NAME_MAX_LENGTH;
    }

    private static boolean isNonDuplicatedNames(List<String> names) {
        return names.size() == names.stream().distinct().count();
    }
}
