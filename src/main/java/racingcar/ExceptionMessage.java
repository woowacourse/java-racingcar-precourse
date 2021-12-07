package racingcar;

public enum ExceptionMessage {

    INVALID_CAR_NAME("자동차의 이름은 5자 이하, 1자 이상이어야 한다."),
    COUNT_MUST_BE_POSITIVE_INTEGER("시도 횟수는 양수인 정수여야 한다."),
    COUNT_MUST_GRATER_THAN_ZERO("시도 횟수는 0이상이어야 한다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}