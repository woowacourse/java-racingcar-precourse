package utils;

public class ValidatorUtils {

    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_VALUE_ONE = 1;
    private static final String ERR0R_PREFIX = "[ERROR] ";
    private static final String OVER_FIVE_LETTERS = ERR0R_PREFIX + "자동차 이름은 5자 이하이어야 한다.";
    private static final String EMPTY_LETTER = ERR0R_PREFIX + "모든 자동차는 이름이 있어야 한다.";
    private static final String MUST_BE_NUMBER = ERR0R_PREFIX + "시도 횟수는 숫자여야 한다.";
    private static final String MUST_BE_POSITIVE_INTEGER = ERR0R_PREFIX + "시도 횟수는 양수여야 한다.";

    private ValidatorUtils() {

    }

    public static void checkUnderFiveLetters(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException(OVER_FIVE_LETTERS);
            }
            if (carName.length() < MIN_VALUE_ONE) {
                throw new IllegalArgumentException(EMPTY_LETTER);
            }
        }
    }

    public static void checkIsNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < MIN_VALUE_ONE) {
                throw new IllegalArgumentException(MUST_BE_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(MUST_BE_NUMBER);
        }
    }
}
