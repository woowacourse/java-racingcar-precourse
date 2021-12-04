package racingcar;

public enum ExceptionMessage {

    TOO_LONG_CAR_NAME("자동차의 이름은 5자 이하여야합니다."),
    COUNT_MUST_BE_INTEGER("시도 횟수는 숫자여야 한다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}