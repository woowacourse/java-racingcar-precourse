package utils;

public class ErrorMessage {

    public static String getLengthErrorMessage(String data) {
        return InputValidator.NAME_LENGTH_ERROR_MESSAGE + " "
                + data + " 이전까지의 자동차가 생성되었습니다.";
    }
}