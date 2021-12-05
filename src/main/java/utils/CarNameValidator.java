package utils;

public class CarNameValidator extends RuntimeException {

    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 length 자 이하만 가능합니다. name 이전까지의 자동차가 생성되었습니다.";
    public static final int CAR_NAME_LENGTH = 5;

    public static void validateLengthInRange(String data) {
        if (data.length() > CAR_NAME_LENGTH) {
            String errorMessage = getLengthErrorMessage(data);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static String getLengthErrorMessage(String data) {
        return NAME_LENGTH_ERROR_MESSAGE
                .replaceFirst("length", String.valueOf(CAR_NAME_LENGTH))
                .replaceFirst("name", data);
    }
}