package racingcar.util;

public enum ErrorMessage {
    CAR_NAME_LENGTH_ERROR_MESSAGE("[ERROR] 자동차 이름은 5자 이하만 가능하다."),
    NOT_DIGIT_ERROR_MESSAGE("[ERROR] 시도 횟수는 숫자여야 한다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
