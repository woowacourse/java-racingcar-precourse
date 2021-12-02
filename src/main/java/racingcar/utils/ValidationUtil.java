package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationUtil {
    public static final String EMPTY_STRING = "";
    public static final int FIRST_INDEX = 0;
    public static final char CHAR_COMMA = 44;
    public static final int MAX_LENGTH = 5;
    public static final String DELIMITER = ",";
    public static final String ERROR_STRING = "[ERROR]";
    public static final String ERROR_EMPTY_MENTION = ERROR_STRING + " 이름을 입력해주세요.";
    public static final String ERROR_OVER_LENGTH_MENTION = ERROR_STRING + " 이름은 " + MAX_LENGTH + "글자까지만 입력가능합니다.";
    public static final String ERROR_START_COMMA_MENTION = ERROR_STRING + " 입력값은 쉼표(,)로 시작할 수 없습니다.";
    public static final String ERROR_DUPLICATE_MENTION = ERROR_STRING + " 이름은 중복될 수 없습니다.";

    public static void checkName(String value) {
        checkNull(value);
        checkEmpty(value);
        checkLength(value);
    }

    public static void checkNames(String value) {
        checkNull(value);
        checkEmpty(value);
        checkCommaInFirst(value);
        checkDuplicate(value);
    }

    static void checkDuplicate(String value) {
        if (hasDuplicate(value.trim())) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MENTION);
        }
    }

    private static boolean hasDuplicate(String value) {
        List<String> names = Arrays.stream(value.split(DELIMITER)).map(String::trim).collect(Collectors.toList());
        return names.stream().distinct().count() != names.size();
    }

    static void checkNull(String value) {
        if (isNull(value)) {
            throw new IllegalArgumentException(ERROR_EMPTY_MENTION);
        }
    }

    static void checkCommaInFirst(String value) {
        if (isCommaInFirst(value.trim())) {
            throw new IllegalArgumentException(ERROR_START_COMMA_MENTION);
        }
    }

    private static boolean isCommaInFirst(String value) {
        return value.charAt(FIRST_INDEX) == CHAR_COMMA;
    }

    public static void checkEmpty(String value) {
        if (isEmpty(value.trim())) {
            throw new IllegalArgumentException(ERROR_EMPTY_MENTION);
        }
    }

    private static boolean isNull(String value) {
        return null == value;
    }

    private static boolean isEmpty(String value) {
        return EMPTY_STRING.equals(value);
    }

    static void checkLength(String value) {
        if (isOverLength(value.trim())) {
            throw new IllegalArgumentException(ERROR_OVER_LENGTH_MENTION);
        }
    }

    private static boolean isOverLength(String value) {
        return value.length() > MAX_LENGTH;
    }
}
