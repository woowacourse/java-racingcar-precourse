package utils;

public class Validator {
    private static final int NAME_LENGTH_MAX_VALUE = 5;
    private static final String NULL = "";
    private static final String OVER_LENGTH_MESSAGE = "[ERROR] 게임 참가자 이름의 길이는 5 이하 여야 합니다.";
    private static final String LENGTH_ZERO_MESSAGE = "[ERROR] 게임 참가자 이름의 길이는 0 보다 커야 합니다.";

    public static void checkInputLengthLessThanValue(String input) {
        if (input.length() > NAME_LENGTH_MAX_VALUE) {
            throw new IllegalArgumentException(OVER_LENGTH_MESSAGE);
        }
    }

    public static void checkInputLengthNotZero(String input) {
        if (input.equals(NULL)) {
            throw new IllegalArgumentException(LENGTH_ZERO_MESSAGE);
        }
    }
}
