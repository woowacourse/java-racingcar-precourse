package utils;

public class InputNumberValidator extends RuntimeException {

    public static final String NUMBER_OF_RACES_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    public static final String NUMBER_OF_RACES_NEGATIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수만 입력 가능합니다.";
    public static final int NUMBER_OF_RACES_MIN = 1;

    public static boolean isSatisfyNumberOfRaces(String data) {
        validateNumber(data);
        validatePositiveNumber(data);
        return true;
    }

    private static void validatePositiveNumber(String data) {
        int number = Integer.parseInt(data);
        if (number < NUMBER_OF_RACES_MIN) {
            throw new IllegalArgumentException(NUMBER_OF_RACES_NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static void validateNumber(String data) {
        try {
            Integer.parseInt(data);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_RACES_FORMAT_ERROR_MESSAGE);
        }
    }
}