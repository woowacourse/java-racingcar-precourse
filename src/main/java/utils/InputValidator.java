package utils;

public class InputValidator {

    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static final int CAR_NAME_LENGTH = 5;

    public static void lengthInRange(String data) {
        if(data.length() > CAR_NAME_LENGTH) {
            String errorMessage = ErrorMessage.getLengthErrorMessage(data);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}