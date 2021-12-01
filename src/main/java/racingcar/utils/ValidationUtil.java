package racingcar.utils;

public class ValidationUtil {
    public static final int MAX_LENGTH = 5;
    public static final String EMPTY_MENTION = "[ERROR] 이름을 입력해주세요.";
    public static final String OVER_LENGTH_MENTION = "[ERROR] 이름은 " + MAX_LENGTH + "글자까지만 입력가능합니다.";
    public static final String EMPTY_STRING = "";

    public static void checkName(String value) {
        checkEmpty(value);
        checkLength(value);
    }

    public static void checkEmpty(String value) {
        if (isNull(value) || isEmpty(value)) {
            throw new IllegalArgumentException(EMPTY_MENTION);
        }
    }

    private static boolean isNull(String value) {
        return null == value;
    }

    private static boolean isEmpty(String value) {
        return EMPTY_STRING.equals(value);
    }

    private static void checkLength(String value) {
        if (isOverLength(value)) {
            throw new IllegalArgumentException(OVER_LENGTH_MENTION);
        }
    }

    private static boolean isOverLength(String value) {
        return value.length() > MAX_LENGTH;
    }
}
