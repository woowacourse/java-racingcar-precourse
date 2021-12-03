package utils;

public class InputValidator {

    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static final String NUMBER_OF_RACES_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    public static final String NUMBER_OF_RACES_NEGATIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수만 입력 가능합니다.";
    public static final int CAR_NAME_LENGTH = 5;
    public static final int NUMBER_OF_RACES_MIN = 1;

    public static void lengthInRange(String data) {
        if(data.length() > CAR_NAME_LENGTH) {
            String errorMessage = ErrorMessage.getLengthErrorMessage(data);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static boolean isSatisfyNumberOfRaces(String data) {
        validateNumber(data);
        validatePositiveNumber(data);
        return true;
    }

    public static void validatePositiveNumber(String data) {
        int number = Integer.parseInt(data);
        if (number < NUMBER_OF_RACES_MIN) {
            throw new IllegalArgumentException(NUMBER_OF_RACES_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void validateNumber(String data) {
        try {
            Integer.parseInt(data);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_RACES_FORMAT_ERROR_MESSAGE);
        }
    }
}