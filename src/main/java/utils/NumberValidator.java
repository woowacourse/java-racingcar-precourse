package utils;

public class NumberValidator {
    private static final int NON_RACE_VALUE = 0;
    private static final String VALUE_OVER_ZERO_MESSAGE = "[ERROR] 게임 시도 회수는 0 보다 커야 합니다.";

    public static void checkNumberOverZero(int input) {
        if (input <= NON_RACE_VALUE) {
            throw new IllegalArgumentException(VALUE_OVER_ZERO_MESSAGE);
        }
    }
}
